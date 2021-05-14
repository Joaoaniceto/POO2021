import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DriveItDelegate {
    private DriveIt model;
    private Menu menuPrincipal, menuVeiculos;
    private Scanner scannerIn;

    public DriveItDelegate(DriveIt model){
        this.model = model;
        this.menuPrincipal = new Menu(new String[] {"Gestão de Veiculos",
                                                    "Registar um Veículo",
                                                    "Alterar nome da Empresa",});
        this.menuVeiculos = new Menu(new String[] {"Listar Veiculos"});
        this.scannerIn = new Scanner(System.in);
    }

    public void run() {
        do {
            System.out.println(" .: Bem-vindo à " + this.model.getNome() + " :.");

            this.menuPrincipal.executa();
            switch (this.menuPrincipal.getOpcao()) {
                case 1:
                    System.out.println("Entrei no Gestão de Veiculos");
                    listarVeiculos();
                case 2:
                    System.out.println("Aqui pode registar um veículo");
                    registaAluger();
                case 3:
                    System.out.println("Entrei na mudança de nome");
                    mudaNome();
            }
        } while (this.menuPrincipal.getOpcao() != 0) ;
            System.out.println("Até breve!");

    }

    private void mudaNome() {
        String newName;
        System.out.println("Indique o novo Nome: ");
        newName = scannerIn.nextLine();
        this.model.setNome(newName);
        System.out.println("Nome alterado com sucesso");
    }

    private void gestaoVeiculos(){
        do {
            System.out.println("Gestão de Veiculos");
            this.menuVeiculos.executa();
            switch (this.menuVeiculos.getOpcao()) {
                case 1: this.listarVeiculos();
                        break;
                case 2: this.registaAluger();
                        break;
            }
        } while (this.menuVeiculos.getOpcao() != 0);
    }

    private void listarVeiculos() {
        System.out.println(this.model.getVeiculos().toString());
    }

    private void registaAluger() {
        List<Veiculo> listaV = (List<Veiculo>) this.model.getVeiculos().values();
        List<String> matriculas = listaV.stream().map(Veiculo::getMatricula)
                                                 .collect(Collectors.toList());
        Menu menuMatriculas = new Menu(listaV.stream().map(Veiculo::getMatricula)
                                                      .collect(Collectors.toList()));


        do {
            menuMatriculas.executa();

            int op = menuMatriculas.getOpcao();
            if (op != 0){
                String mat = matriculas.get(op-1);
                int kms;
                System.out.println("Kms: ");
                kms = Integer.parseInt(scannerIn.nextLine());
                this.model.registarAluguer(mat,kms);
            } while (menuMatriculas.getOpcao() != 0);




            switch (menuMatriculas.getOpcao()) {
                case 1: this.listarVeiculos();
                    break;
                case 2: this.registaAluger();
                    break;
            }
        } while (this.menuVeiculos.getOpcao() != 0);
    }
}
