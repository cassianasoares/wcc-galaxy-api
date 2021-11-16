package dao

import model.Location
import java.util.concurrent.atomic.AtomicInteger

class LocationDao {

    private val locations = hashMapOf(
        0 to Location(
            id = 0,
            mensagem = "Voce esta em algum lugar na galaxia Andromedra",
            longitude = 41.40338,
            latitude = 2.17403,
            galaxia = "Andromedra"
        ),
        1 to Location(
            id = 1,
            mensagem = "Voce esta no Planeta de Gatos Super Carinhosos",
            longitude = 61.40338,
            latitude = 6.17403,
            galaxia = "Andromedra",
            planeta = "Planeta de Gatos Super Carinhosos"
        ),
        2 to Location(
            id = 2,
            mensagem = "Faco a minima ideia, nao foi nomeado ainda este planeta",
            longitude = 51.40338,
            latitude = 5.17403,
            galaxia = "Somewhere",
            planeta = "Stelar"
        ),
        3 to Location(
            id = 3,
            mensagem = "Hummmm... nao conheco essa localizacao, voce tera que inseri-la",
            longitude = 0.0,
            latitude = 0.0
        )
    )

    var lastId: AtomicInteger = AtomicInteger(locations.size - 1)

    //save location
    fun save( location: Location){
        val id = lastId.incrementAndGet()
        locations.put(id, Location(
            id = id, mensagem = location.mensagem, longitude = location.longitude,
            latitude = location.latitude, galaxia = location.galaxia, planeta = location.planeta
        )
        )
    }

    //get all location
    fun getAllLocations() = locations

    //get random location
    fun getRandomLocation(): Location {
        val randomId = (0..3).random()
        return locations[randomId]!!
    }

    //get by id
    fun findById(id: Int): Location?{
        return locations[id]
    }

    //delete location
    fun delete(id: Int){
        locations.remove(id)
    }

    //update location
    fun update(id: Int, location: Location){
        locations.put(id,
            Location(
                id = id,
                mensagem = location.mensagem,
                longitude = location.longitude,
                latitude = location.latitude,
                galaxia = location.galaxia,
                planeta = location.planeta
            )
        )
    }
}