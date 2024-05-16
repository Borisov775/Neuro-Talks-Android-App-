package ru.asselinux.architecturecomponents.room

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.asselinux.architecturecomponents.R
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.data.User
import java.time.LocalDate
import java.util.*

@Database(entities = [Item::class, User::class], version=2)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDataBase(
            context: Context,
            scope: CoroutineScope
        ): ItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "post_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(ItemDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun populateDatabase(itemDao: ItemDao,userDao: UserDao) {
            itemDao.insert(Item("BCI","We could use those technologies in many kinds of humankind s activities, for example, astronauts using non-implanted BCI could remote control the manipulator instead of going out in space to catch radiation.", "Распознавание эмоций человека посредством новых систем и программ, стало актуальным и перспективным направлением в области аффективных вычислений.  Эмоции играют существенную роль в формировании человеческого интеллекта и всех социальных взаимодействий в целом.\n" +
                    "        Эмоции составляют ключевую часть нашего интеллекта, психологи также называют это эмоциональным интеллектом. Но что такое эмоция?\n" +
                    "        Эмоция - это сложное состояние человека, характеризирующееся физиологическими и когнитивными процессами на ответ реакции, исходящей из внешнего мира.\n" +
                    "        Эмоция не является сугубо психологической субстанцией мышления человека.\n" +
                    "    Существуют также ряд различный моделей,  которые классифицируют эмоции по продолжительности, валентности и степени возбуждения эмоций. Благодаря развитию в области машинного и глубокого обучения появились решения, которые позволяют машинам распознавать и анализировать эмоции человека. Однако наряду с умными алгоритмами классификации возникает сложности с идентификацией а именно сбором человеческих эмоций. Ведь выражения лица, речь, поведение человека могут быть неэффективным источником сбора информации. Поэтому с появлением более чувстительных сенсорных технологий, таких как BCI (brain-computer interface) стало возможным считывание физиологических сигналов, которые улавливают сигналы мозга и используют их в качесвте входных данных для систем, которые понимают корреляцию между эмоциями и изменениями ЭЭГ, а также исключают социальную маркировку (скрытие эмоций).","Neurosciences","CS","BCI",
            "https://www.unite.ai/wp-content/uploads/2021/05/technology-3358837_1280.jpg",45,45,LocalDate.now().toString(),"georgeborisov02@gmail.com","George Borisov",15,"https://yandex.ru/search/?text=robert+sapolsky&lr=118936&clid=2261451&win=518&src=suggest_T",
            "https://neptune.ai/blog/fighting-overfitting-with-l1-or-l2-regularization","https://www.themindvoyager.com/robert-sapolsky-lecture-14-limbic-system/"))
            itemDao.insert(Item("BCI","We could use those technologies in many kinds of humankind s activities, for example, astronauts using non-implanted BCI could remote control the manipulator instead of going out in space to catch radiation.",
                "Распознавание эмоций человека посредством новых систем и программ, стало актуальным и перспективным направлением в области аффективных вычислений.  Эмоции играют существенную роль в формировании человеческого интеллекта и всех социальных взаимодействий в целом.\n" +
                        "        Эмоции составляют ключевую часть нашего интеллекта, психологи также называют это эмоциональным интеллектом. Но что такое эмоция?\n" +
                        "        Эмоция - это сложное состояние человека, характеризирующееся физиологическими и когнитивными процессами на ответ реакции, исходящей из внешнего мира.\n" +
                        "        Эмоция не является сугубо психологической субстанцией мышления человека.\n" +
                        "    Существуют также ряд различный моделей,  которые классифицируют эмоции по продолжительности, валентности и степени возбуждения эмоций. Благодаря развитию в области машинного и глубокого обучения появились решения, которые позволяют машинам распознавать и анализировать эмоции человека. Однако наряду с умными алгоритмами классификации возникает сложности с идентификацией а именно сбором человеческих эмоций. Ведь выражения лица, речь, поведение человека могут быть неэффективным источником сбора информации. Поэтому с появлением более чувстительных сенсорных технологий, таких как BCI (brain-computer interface) стало возможным считывание физиологических сигналов, которые улавливают сигналы мозга и используют их в качесвте входных данных для систем, которые понимают корреляцию между эмоциями и изменениями ЭЭГ, а также исключают социальную маркировку (скрытие эмоций).","Neurosciences","CS","BCI",
                "https://www.unite.ai/wp-content/uploads/2021/05/technology-3358837_1280.jpg",45,45,LocalDate.now().toString(),"georgeborisov02@gmail.com","George Borisov",15,"https://yandex.ru/search/?text=robert+sapolsky&lr=118936&clid=2261451&win=518&src=suggest_T",
                "https://neptune.ai/blog/fighting-overfitting-with-l1-or-l2-regularization","https://www.themindvoyager.com/robert-sapolsky-lecture-14-limbic-system/"))
            itemDao.insert(Item("BCI","We could use those technologies in many kinds of humankind s activities, for example, astronauts using non-implanted BCI could remote control the manipulator instead of going out in space to catch radiation.",
                "Распознавание эмоций человека посредством новых систем и программ, стало актуальным и перспективным направлением в области аффективных вычислений.  Эмоции играют существенную роль в формировании человеческого интеллекта и всех социальных взаимодействий в целом.\n" +
                        "        Эмоции составляют ключевую часть нашего интеллекта, психологи также называют это эмоциональным интеллектом. Но что такое эмоция?\n" +
                        "        Эмоция - это сложное состояние человека, характеризирующееся физиологическими и когнитивными процессами на ответ реакции, исходящей из внешнего мира.\n" +
                        "        Эмоция не является сугубо психологической субстанцией мышления человека.\n" +
                        "    Существуют также ряд различный моделей,  которые классифицируют эмоции по продолжительности, валентности и степени возбуждения эмоций. Благодаря развитию в области машинного и глубокого обучения появились решения, которые позволяют машинам распознавать и анализировать эмоции человека. Однако наряду с умными алгоритмами классификации возникает сложности с идентификацией а именно сбором человеческих эмоций. Ведь выражения лица, речь, поведение человека могут быть неэффективным источником сбора информации. Поэтому с появлением более чувстительных сенсорных технологий, таких как BCI (brain-computer interface) стало возможным считывание физиологических сигналов, которые улавливают сигналы мозга и используют их в качесвте входных данных для систем, которые понимают корреляцию между эмоциями и изменениями ЭЭГ, а также исключают социальную маркировку (скрытие эмоций).","Neurosciences","CS","BCI",
                "https://www.unite.ai/wp-content/uploads/2021/05/technology-3358837_1280.jpg",45,45,LocalDate.now().toString(),"georgeborisov02@gmail.com","George Borisov",15,"https://yandex.ru/search/?text=robert+sapolsky&lr=118936&clid=2261451&win=518&src=suggest_T",
                "https://neptune.ai/blog/fighting-overfitting-with-l1-or-l2-regularization","https://www.themindvoyager.com/robert-sapolsky-lecture-14-limbic-system/"))
            userDao.insert(User("George","Borisov","georgeborisov02@gmail.com","Tango7","Software Engineering"))

        }

        private class ItemDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.itemDao(),database.userDao())
                    }
                }
            }
        }
    }
}
