package io.abc.labs.orientdb

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.io.File

@RunWith(SpringRunner::class)
@SpringBootTest
class DbFactoryTests {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(DbFactoryTests::class.java)

        @BeforeClass
        @JvmStatic
        fun setup() {
            val dbHome = File("").absolutePath

            System.setProperty("ORIENTDB_HOME", "$dbHome/build")

            LOGGER.info("DB HOME \"$dbHome\"")
        }

        @AfterClass
        @JvmStatic
        fun cleanup() {
            System.clearProperty("ORIENTDB_HOME")
        }
    }

    @Autowired
    lateinit var factory: DbFactory


    @Test
    fun createDb() {
        factory.create()
    }
}
