public class TesteFabricaBolos {
    public static void main(String[] args) {
        // Criando um formato fictício para os bolos (área fixa para fins de teste)
        IFormato formato = () -> 20.0; // Área fixa de 20 para facilitar os cálculos        

        // Criando bolos
        BoloSimples bolo1 = new BoloSimples(101, 10.0, formato);
        BoloSimples bolo2 = new BoloSimples(102, 15.0, formato, true);
        Torta torta1 = new Torta(201, 20.0, formato);
        Torta torta2 = new Torta(202, 25.0, formato, true, false);

        // Criando a prateleira com capacidade para 5 bolos
        VetorPrateleira prateleira = new VetorPrateleira(5);

        // Testando inserção de bolos
        System.out.println("Inserindo bolos...");
        prateleira.inserir(bolo1);
        prateleira.inserir(bolo2);
        prateleira.inserir(torta1);
        prateleira.inserir(torta2);

        // Tentando inserir um bolo repetido
        System.out.println("Tentando inserir um bolo já cadastrado:");
        prateleira.inserir(bolo1); // Deve exibir "Bolo já cadastrado."

        // Listando todos os bolos
        System.out.println("\nLista de todos os bolos:");
        for (IBolo bolo : prateleira.listar()) {
            System.out.println(bolo);
        }

        // Listando bolos simples
        System.out.println("\nLista de bolos simples:");
        for (IBolo bolo : prateleira.listar('S')) {
            System.out.println(bolo);
        }

        // Listando tortas
        System.out.println("\nLista de tortas:");
        for (IBolo bolo : prateleira.listar('T')) {
            System.out.println(bolo);
        }

        // Removendo um bolo pelo objeto
        System.out.println("\nRemovendo bolo 102...");
        prateleira.remover(bolo2);

        // Listando após a remoção
        System.out.println("\nLista após remoção do bolo 102:");
        for (IBolo bolo : prateleira.listar()) {
            System.out.println(bolo);
        }

        // Removendo por posição
        System.out.println("\nRemovendo bolo na posição 0...");
        prateleira.remover(0);

        // Listando após a remoção
        System.out.println("\nLista após remoção da posição 0:");
        for (IBolo bolo : prateleira.listar()) {
            System.out.println(bolo);
        }
    }
}