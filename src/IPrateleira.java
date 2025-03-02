public interface IPrateleira
{
    int buscar(IBolo bolo);
    boolean cheia ();
    boolean vazia ();
    boolean existe (IBolo bolo);
    boolean inserir (IBolo bolo);
    IBolo remover (IBolo bolo);
    IBolo remover (int posicao);
    IBolo consultar (IBolo bolo);
    IBolo[] listar ();
    IBolo[] listar (char tipoDoBolo);
}