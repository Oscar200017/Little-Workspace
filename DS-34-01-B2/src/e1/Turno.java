package e1;

public enum Turno {
    M("Mañana"), T("Tarde"), N("Noche");
    
    private String turno;

    private Turno(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
    

}
