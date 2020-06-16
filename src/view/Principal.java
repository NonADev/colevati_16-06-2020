package view;

//Acessar a tarefa Aula 16/06/2020:
//Baixar o arquivo definido no cabeçalho da tarefa
//Criar o projeto Java com as especificações
//Subir o projeto no Github
//Responder a tarefa com o link do projeto

import controller.ArquivosController;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        String arquivo = "./TEMP/colavatanus.csv";
        ArquivosController a = new ArquivosController();
        a.verificaDirTemp();
        a.verificaRegistro(arquivo,12);
        a.imprimeCadastro(arquivo,12);
        a.insereCadastro(arquivo, 12, "wesley", "wesley@colevatanus.com");
    }
}
