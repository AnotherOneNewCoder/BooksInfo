package ru.zhogin.book.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "BookInfo")
            os.contains("mac") -> File(userHome, "Library/Application Support/BookInfo")
            else -> File(userHome, ".local/share/BookInfo")
        }
        if (!appDataDir.exists()) {
            appDataDir.mkdirs()
        }
        val dbFile = File(appDataDir, FavoriteBookDatabase.DB_NAME)
        return Room.databaseBuilder(
            name = dbFile.absolutePath
        )
    }
}