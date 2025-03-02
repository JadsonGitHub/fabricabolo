public class Torta extends Bolo
{
    private boolean recheio;
    private boolean cobertura;

    public Torta(int codigo, double custo, IFormato formato)
    {
        super(codigo, custo, formato);
        this.recheio = true;  // Padrão
        this.cobertura = true; // Padrão
    }
    public Torta(int codigo, double custo, IFormato formato, boolean recheio, boolean cobertura)
    {
        super(codigo, custo, formato);
        this.recheio = recheio;
        this.cobertura = cobertura;
    }
    @Override
    public double preco()
    {
        double precoBase = getCusto() * getFormato().area();
        if (recheio) precoBase += 12.50;
        if (cobertura) precoBase += 20.00;
        return precoBase;
    }
    @Override
    public String toString()
    {
        return super.toString() + ", Recheio: " + (recheio ? "Sim" : "Não") +
               ", Cobertura: " + (cobertura ? "Sim" : "Não") + 
               ", Preço: R$ " + preco();
    }
}