from flask import Flask, json

api = Flask(__name__)

product_data = {}
irrigation_data = {}
soil_data = {}
weather_data = {}

# load data
def load_data():
    global product_data, irrigation_data, soil_data, weather_data
    with open("./product.json") as f:
        product_data = json.load(f)
    with open("./irrigation.json") as f:
        irrigation_data = json.load(f)
    with open("./soil.json") as f:
        soil_data = json.load(f)
    with open("./weather.json") as f:
        weather_data = json.load(f)
    

@api.route('/product/types', methods=['GET'])
def get_product_types():
    return json.dumps({"types": list(product_data.keys())})

@api.route('/product/info/<ptype>', methods=['GET'])
def get_product_info(ptype):
    return json.dumps(product_data.get(ptype, ""), indent=4)

@api.route('/soil/<area>', methods=['GET'])
def get_area_soil(area):
    return json.dumps(soil_data.get(area, ""), indent=4)

@api.route('/weather/<area>', methods=['GET'])
def get_area_weather(area):
    return json.dumps(weather_data.get(area, ""), indent=4)

@api.route('/waterirrigation/<area>', methods=['GET'])
def get_area_irrigation(area):
    return json.dumps(irrigation_data.get(area, ""), indent=4)


if __name__ == '__main__':
    load_data()
    api.run()