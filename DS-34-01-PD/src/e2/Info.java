package e2;

public enum Info {

    cierre(1),
    maximo(2),
    minimo(3),
    volumen(4);

    private Integer key;

    public Integer getKey() {
        return key;
    }

    private Info(Integer key) {
        this.key = key;
    }

}
