package io.abc.labs.orientdb

import com.orientechnologies.orient.server.OServer
import com.orientechnologies.orient.server.OServerMain
import org.springframework.stereotype.Service


/**
 * @author tam.nguyen
 */

class Db(private val server: OServer)

@Service
class DbFactory {

    fun create(): Db {

        val server = OServerMain.create()

        // start db server
        server.startup(DbFactory::class.java.getResourceAsStream("/db-config.xml"))
        server.activate()

//        server.waitForShutdown()

        return Db(server)
    }
}