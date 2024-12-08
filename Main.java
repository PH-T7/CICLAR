import dao.ColetorDAO;
import model.Coletor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ColetorDAO coletorDAO = new ColetorDAO();

        // Inserir novo coletor
        Coletor novoColetor = new Coletor(6, "Fernando Alves", "99999-1111", "Zona Leste");
        boolean sucesso = coletorDAO.adicionarColetor(novoColetor);
        System.out.println("Coletor inserido: " + sucesso);

        // Listar todos os coletores
        List<Coletor> coletores = coletorDAO.getTodosColetores();
        System.out.println("Coletores cadastrados:");
        coletores.forEach(coletor -> System.out.println(
            coletor.getColetorId() + " - " + coletor.getNome() + " - " + coletor.getTelefone() + " - " + coletor.getAreaAtuacao()
        ));
    }
}