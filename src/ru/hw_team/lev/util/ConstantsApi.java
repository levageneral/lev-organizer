package ru.hw_team.lev.util;

import ru.hw_team.lev.ui.main.MainActivity;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.09.13
 */
public interface ConstantsApi {
    /*не используй константы через имплементирование интерфайса
    * "implements  Constants" - это антипатерн
    * Используй интерфейс плюс статический импорт "import static ru.hw_team.lev.ui.Constants.*;"
    * Не нужно указывать у интерфейса "public static final" по умолчанию у интерфейсов все поля такие*/
    static final String TAG = MainActivity.class.getSimpleName();
 }
