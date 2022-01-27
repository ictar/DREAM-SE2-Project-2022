import requests
import json
from lxml import html

basic = r"https://www.tsdps.telangana.gov.in/"
access = basic + r"aws.jsp"

def get(url):
    resp = requests.get(url)
    return resp.content

def getDistricts(url, saveto):
    tree = html.fromstring(get(url))

    print(tree.xpath('//div[@id="dp_content_map1"]/div/table//tr/td[2]/div/select/option/text()'))
    return
    links = tree.xpath('//div[@id="dp_content_map1"]/div/table//tr/td[2]/div/select/option/@value')[1:]

    data = {}
    for link in links:
        if link == "live/ghmc/index.jsp":
            continue

        print("process ", link)
        optr = html.fromstring(get(basic+link))
        area = optr.xpath('//*[@id="dp_content_map1"]/div/table//tr/td[2]/div/span/text()')[0].split("in")[-1].strip().split(" District")[0]

        print("for area ", area)
        rainfall = {}
        # classfication
        classfication = optr.xpath('//*[@id="rainfall"]/table//tr[3]/td/div/text()')
        rfrange = optr.xpath('//*[@id="rainfall"]/table//tr[4]/td/div/text()')
        stationno = optr.xpath('//*[@id="rainfall"]/table//tr[5]/td/div/text()')
        #print(classfication, rfrange, stationno)
        for i in range(0, len(classfication)):
            if i == len(classfication) - 1:
                rainfall[classfication[i]] = {
                "range": "",
                "aws_station_count": stationno[i]
                }
            else:
                rainfall[classfication[i]] = {
                "range":rfrange[i] + " mm",
                "aws_station_count": stationno[i]
                }

        data[area] = {"rainfall": rainfall}

    with open(saveto, "w") as f:
        f.write(json.dumps(data, indent=4))

def getDistrictImage(url, saveto=None):
    tree = html.fromstring(get(url))

    print(tree.xpath('//div[@id="dp_content_map1"]/div/table//tr/td[2]/div/select/option/text()'))
    links = tree.xpath('//div[@id="dp_content_map1"]/div/table//tr/td[2]/div/select/option/@value')[1:]

    data = {}
    for link in links:
        if link == "live/ghmc/index.jsp":
            continue

        print("process ", link)
        optr = html.fromstring(get(basic+link))
        area = optr.xpath('//*[@id="dp_content_map1"]/div/table//tr/td[2]/div/span/text()')[0].split("in")[-1].strip().split(" District")[0]

        imagepath = basic + optr.xpath('//*[@id="mapImage"]/@src')[0]
        name = imagepath.split('/')[-1]
        print(area, " : ", imagepath, name)
        #save
        with open(saveto+name, "wb") as f:
            f.write(get(imagepath))


if __name__ == "__main__":
    #getDistricts(access, "weather.json")
    getDistrictImage(access, "./image/")