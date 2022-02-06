import json
from datetime import date

import random


areas = ['Adilabad', 'Bhadradri-Kothagudem', 'GHMC', 'Hyderabad', 'Jagitial', 'Jangaon', 'Jayashankar', 'Jogulamba-Gadwal', 'Kamareddy', 'Karimnagar', 'Khammam', 'Kumaram Bheem-Asifabad', 'Mahabubabad', 'Mahabubnagar', 'Mancherial', 'Medak', 'Medchal-Malkajgiri', 'Mulugu', 'Nagarkurnool', 'Nalgonda', 'Narayanapet', 'Nirmal', 'Nizamabad', 'Peddapalli', 'Rajanna-Siricilla', 'Rangareddy', 'Sangareddy', 'Siddipet', 'Suryapet', 'Vikarabad', 'Wanaparthy', 'Warangal', 'Hanumakonda', 'Yadadri-Bhongir']

def fake_soil(saveto):
    data = {}

    for area in areas:
        data[area] = {
            "temperature": round(random.uniform(20, 30), 2),
            "moisture": round(random.uniform(0.1, 0.5), 3),
            "fertility": {
                "pH": round(random.uniform(6.5, 8.5), 1),
                "ElectricalConductivity": round(random.uniform(0, 1), 1),
                "OrganicCarbon": round(random.uniform(0.2, 0.75), 2),
                "Nitrogen": round(random.uniform(100, 280), 0),
            }
        }
    
    with open(saveto, "w") as f:
        f.write(json.dumps(data, indent=4))

def fake_irrigation(saveto):
    data = {}

    for area in areas:
        data[area] = {
            "consumption": round(random.uniform(10000, 30000), 2),
            "date": str(date.today()),
        }

    with open(saveto, "w") as f:
        f.write(json.dumps(data, indent=4))


if __name__ == '__main__':
    fake_soil("soil.json")
    #fake_irrigation("irrigation.json")