package e1;

public enum EuroCoin {
    Euro_200(200),
    Euro_100(100),
    Euro_50(50),
    Euro_20(20),
    Euro_10(10),
    Euro_5(5),
    Euro_2(2),
    Euro_1(1);

    private Integer valor;

    private EuroCoin(Integer valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

 
}
