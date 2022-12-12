package Enums;

public enum FigureType {
    Z, I, O, L, J;

    public static FigureType getType(int i) {return values()[i];}
}
