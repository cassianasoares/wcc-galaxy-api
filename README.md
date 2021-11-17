# REST API KOTLIN application

This is a simple api location exercise with kotlin to do CRUD. <br>
The REST API app is described below.



## Get list of locations
 
### Request

`GET /locations/`

    curl -i -H 'Accept: application/json' http://localhost:7000/locations/
### Response

>Status: 200 OK
    
    [
      "0": {
        "id": 0,
        "mensagem": "Voce esta em algum lugar na galaxia Andromedra",
        "longitude": 41.40338,
        "latitude": 2.17403,
        "galaxia": "Andromedra",
        "planeta": "planeta nao identificado :("
        }
    ]
    
    
## Get random location
 
### Request

`GET /locations/my-location`

    curl -i -H 'Accept: application/json' http://localhost:7000/locations/my-location    
### Response

>Status: 200 OK
    
    {
      "id": 2,
      "mensagem": "Faco a minima ideia, nao foi nomeado ainda este planeta",
      "longitude": 51.40338,
      "latitude": 5.17403,
      "galaxia": "Somewhere",
      "planeta": "Stelar"
    }
    
    
## Get location by id
 
### Request

`GET /locations/{location-id}`

    curl -i -H 'Accept: application/json' http://localhost:7000/locations/LOCATION-ID    
### Response

>Status: 200 OK
    
    {
      "id": 2,
      "mensagem": "Faco a minima ideia, nao foi nomeado ainda este planeta",
      "longitude": 51.40338,
      "latitude": 5.17403,
      "galaxia": "Somewhere",
      "planeta": "Stelar"
    }    
    
    
## Get location by planet
 
### Request

`GET /locations/{planet-name}`

    curl -i -H 'Accept: application/json' http://localhost:7000/locations/PLANET-NAME    
### Response

>Status: 200 OK
    
    {
      "id": 2,
      "mensagem": "Faco a minima ideia, nao foi nomeado ainda este planeta",
      "longitude": 51.40338,
      "latitude": 5.17403,
      "galaxia": "Somewhere",
      "planeta": "Stelar"
    } 
