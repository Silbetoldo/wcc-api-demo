import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*



fun main(){

//    val app = Javalin.create().start(7000)
//    app.get("/wcc") {ctx -> ctx.result("Olá Deevas! =D")}

//    val malu = User("Maria Luiza", "malu@hotmaul.com" , 1)
//
//    val newNomeMalu = malu.copy("Silva")
//
//    println(malu)
//    println(newNomeMalu)

    val UserDao = UserDao()
    val app = Javalin.create().apply{
        exception(Exception::class.java) { e, ctx -> e.printStackTrace()}
        error(404) { ctx -> ctx.json("NOT FOUND") }
    }.start(7000)

    app.routes {

        // mostrando todos os usuários
        get("/users") { ctx ->
            ctx.json(UserDao.users)
        }

        // buscando o usuario pelo id
        get("/users/{user-id}") { ctx ->
            ctx.json(UserDao.findById(ctx.pathParam("user-id").toInt())!!)
        }
    }

}




