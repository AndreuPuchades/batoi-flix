package com.example.batoiflix.modelo.enums;

public enum Genero {
    ACTION {
        @Override
        public String toString() {
            return "Action";
        }
    }, FANTASY {
        @Override
        public String toString() {
            return "Fantasy";
        }
    }, MUSICAL {
        @Override
        public String toString() {
            return "Musical";
        }
    }, HISTORY {
        @Override
        public String toString() {
            return "History";
        }
    }, SPORT {
        @Override
        public String toString() {
            return "Sport";
        }
    }, BIOGRAPHY {
        @Override
        public String toString() {
            return "Biography";
        }
    }, COMEDY {
        @Override
        public String toString() {
            return "Comedy";
        }
    }, SCI_FI {
        @Override
        public String toString() {
            return "Sci-Fi";
        }
    }, MISTERY {
        @Override
        public String toString() {
            return "Mistery";
        }
    }, WESTERN {
        @Override
        public String toString() {
            return "Western";
        }
    }, HORROR {
        @Override
        public String toString() {
            return "Horror";
        }
    }, FAMILY {
        @Override
        public String toString() {
            return "Family";
        }
    }, ROMANCE {
        @Override
        public String toString() {
            return "Romance";
        }
    }, THRILLER {
        @Override
        public String toString() {
            return "Thriller";
        }
    }, ADVENTURE {
        @Override
        public String toString() {
            return "Adventure";
        }
    }, CRIME {
        @Override
        public String toString() {
            return "Crime";
        }
    }, DRAMA {
        @Override
        public String toString() {
            return "Drama";
        }
    }, ANIMATION {
        @Override
        public String toString() {
            return "Animation";
        }
    }
}