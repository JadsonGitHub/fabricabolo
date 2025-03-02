public abstract class Bolo implements IBolo
{
    private int codigo;
    private double custo;
    private IFormato formato;

    public Bolo(int codigo, double custo)
    {
        this.codigo = codigo;
        this.custo = custo;
        this.formato = null; // Formato pode ser definido depois
    }

    public Bolo(int codigo, double custo, IFormato formato)
    {
        this.codigo = codigo;
        this.custo = custo;
        this.formato = formato;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getCusto() {
        return custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }
    public IFormato getFormato() {
        return formato;
    }
    public void setFormato(IFormato formato) {
        this.formato = formato;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bolo bolo = (Bolo) obj;
        return codigo == bolo.codigo;
    }
    @Override
    public String toString()
    {
        return "Código: " + codigo + ", Custo: R$ " + custo + ", Formato: " +
                (formato != null ? formato.getClass().getSimpleName() : "Nenhum");
    }
}