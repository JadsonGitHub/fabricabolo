public class BoloSimples extends Bolo
{
    private boolean semLactose;

    public BoloSimples(int codigo, double custo, IFormato formato)
    {
        super(codigo, custo, formato);
        this.semLactose = false; // Padrão
    }
    public BoloSimples(int codigo, double custo, IFormato formato, boolean semLactose)
    {
        super(codigo, custo, formato);
        this.semLactose = semLactose;
    }
    @Override
    public double preco()
    {
        double precoBase = getCusto() * getFormato().area();
        if (semLactose) precoBase += 35.00;
        return precoBase;
    }
    @Override
    public String toString()
    {
        return super.toString() + ", Sem Lactose: " + (semLactose ? "Sim" : "Não") + 
               ", Preço: R$ " + preco();
    }
}