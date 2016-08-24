package com.javarush.test.level23.lesson06.task02;

import static com.javarush.test.level23.lesson06.task02.Solution.Constants.*;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public  class Solution {
    public final static class Constants{
       static final String NAC = "Server is not accessible for now.";
        static final String NAUTH = "User is not authorized.";
        static final String BANNED = "User is banned.";
        static final String ADENY = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(NAC);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(NAC, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(NAUTH);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(NAUTH, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(ADENY);
        }

        public RestrictionException(Throwable cause) {
            super(ADENY, cause);
        }
    }
}
