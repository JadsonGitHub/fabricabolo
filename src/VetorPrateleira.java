import java.util.ArrayList;
import java.util.List;

public class VetorPrateleira implements IPrateleira
{
    private IBolo[] prateleira;
    private int qtdBolo;
    // Construtor que define o tamanho da prateleira
    public VetorPrateleira(int tamanho)
    {
        prateleira = new IBolo[tamanho];
        qtdBolo = 0;
    }
    @Override
    public boolean cheia()
    {
        return qtdBolo == prateleira.length;
    }
    @Override
    public boolean vazia()
    {
        return qtdBolo == 0;
    }
    @Override
    public int buscar(IBolo bolo)
    {
        for (int i = 0; i < qtdBolo; i++)
        {
            if (prateleira[i].equals(bolo)) return i;
        }
        return -1;
    }
    @Override
    public boolean existe(IBolo bolo)
    {
        return buscar(bolo) != -1;
    }
    @Override
    public boolean inserir(IBolo bolo)
    {
        if (cheia())
        {
            System.out.println("Prateleira cheia.");
            return false;
        }
        if (existe(bolo))
        {
            System.out.println("Bolo já cadastrado.");
            return false;
        }
        prateleira[qtdBolo++] = bolo;
        return true;
    }
    @Override
    public IBolo remover(IBolo bolo)
    {
        int posicao = buscar(bolo);
        if (posicao == -1)
        {
            System.out.println("Bolo inexistente.");
            return null;
        }
        return remover(posicao);
    }
    @Override
    public IBolo remover(int posicao)
    {
        if (posicao < 0 || posicao >= qtdBolo)
        {
            System.out.println("Bolo inexistente.");
            return null;
        }
        IBolo boloRemovido = prateleira[posicao];
        for (int i = posicao; i < qtdBolo - 1; i++)
        {
            prateleira[i] = prateleira[i + 1];
        }
        prateleira[--qtdBolo] = null;
        return boloRemovido;
    }
    @Override
    public IBolo consultar(IBolo bolo)
    {
        int posicao = buscar(bolo);
        return (posicao != -1) ? prateleira[posicao] : null;
    }
    @Override
    public IBolo[] listar()
    {
        IBolo[] lista = new IBolo[qtdBolo];
        System.arraycopy(prateleira, 0, lista, 0, qtdBolo);
        return lista;
    }
    @Override
    public IBolo[] listar(char tipoDoBolo)
    {
        List<IBolo> listaFiltrada = new ArrayList<>();
        for (int i = 0; i < qtdBolo; i++)
        {
            if ((tipoDoBolo == 'S' && prateleira[i] instanceof BoloSimples) ||
                (tipoDoBolo == 'T' && prateleira[i] instanceof Torta      ))
            {
                listaFiltrada.add(prateleira[i]);
            }
        }
        return listaFiltrada.toArray(new IBolo[0]);
    }
}