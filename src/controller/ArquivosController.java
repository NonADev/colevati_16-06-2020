package controller;

import model.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArquivosController implements IArquivosController {
    public void verificaDirTemp() throws IOException {
        File dir = new File("./TEMP");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
        File csv = new File(arquivo);
        if (!csv.exists()) return false;
        Scanner s = new Scanner(csv);
        while (s.hasNext()) {
            if (Integer.parseInt(s.nextLine().split(";")[0]) == codigo) {
                return true;
            }
        }
        return false;
    }

    private Persona getValueRegistro(String arquivo, int codigo) throws FileNotFoundException {
        File csv = new File(arquivo);
        if (!csv.exists()) return null;
        Scanner s = new Scanner(csv);
        while (s.hasNext()) {
            String person[] = s.nextLine().split(";");
            if (Integer.parseInt(person[0]) == codigo) {
                Persona p = new Persona();
                p.codigo = Integer.parseInt(person[0]);
                p.nome = person[1];
                p.email = person[2];
                return p;
            }
        }
        return null;
    }

    public void imprimeCadastro(String arquivo, int codigo) throws IOException {
        if (verificaRegistro(arquivo, codigo)) {
            Persona p = this.getValueRegistro(arquivo, codigo);
            System.out.println(String.format("Código: %s\nNome: %s\nEmail: %s\n", p.codigo, p.nome, p.email));
        }
    }

    public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
        if(verificaRegistro(arquivo, codigo)) return;
        File f = new File("./TEMP/colavatanus.csv");
        FileWriter fw = new FileWriter(f, true);
        fw.write(String.format("%s;%s;%s",codigo,nome,email));
        fw.close();
    }
}
