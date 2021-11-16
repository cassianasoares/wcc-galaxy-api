import dao.LocationDao
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import model.Location

fun main(){

    val locationDao = LocationDao()

    val app = Javalin.create().apply {
        exception(Exception::class.java){ e, ctx -> e.printStackTrace()}
        error(404){ctx -> ctx.json("NOT FOUND")}
    }.start(7000)

    app.routes{

        //Extra - get my random location
        get("/locations/my_location"){ ctx ->
            ctx.json(locationDao.getRandomLocation())
            ctx.status(200)
        }

        //Exercise 1 -  show all locations
        get("/locations"){ ctx ->
            ctx.json(locationDao.getAllLocations())
            ctx.status(200)
        }

        //Exercise 2 - get location by id
        get("/locations/{location-id}"){ ctx ->
            val locationId = ctx.pathParam("location-id").toInt()
            ctx.json(locationDao.findById(id = locationId)!!)
            ctx.status(200)
        }

        //Challenge 1 - post location
        post("/locations"){ ctx ->
            val location = ctx.bodyAsClass<Location>()
            locationDao.save(location = location)
            ctx.status(201).json("SAVO COM SUCESSO!")
        }

        //Challenge 2 - delete location
        delete("locations/{location-id}"){ ctx ->
            val locationId = ctx.pathParam("location-id").toInt()
            locationDao.delete(id = locationId)
            ctx.status(204)
        }

        //Challenge 3 - update location
        patch("locations/{location-id}"){ ctx ->
            val locationUpdates = ctx.bodyAsClass<Location>()
            val locationId = ctx.pathParam("location-id").toInt()
            locationDao.update(id = locationId, location = locationUpdates)
            ctx.status(204)
        }
    }

}