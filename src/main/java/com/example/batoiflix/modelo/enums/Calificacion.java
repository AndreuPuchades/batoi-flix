package com.example.batoiflix.modelo.enums;

public enum Calificacion {
    G{
        @Override
        public String toString() {
            return "G";
        }
    },PG{
        @Override
        public String toString() {
            return "PG";
        }
    },PG_13{
        @Override
        public String toString() {
            return "PG_13";
        }
    },R{
        @Override
        public String toString() {
            return "R";
        }
    },X{
        @Override
        public String toString() {
            return "X";
        }
    }
}