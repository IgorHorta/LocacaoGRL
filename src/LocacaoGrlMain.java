import Dao.LojaDao;
import controllers.ClienteController;
import controllers.LocacaoController;
import controllers.VeiculoController;
import enums.Categoria;
import exceptions.ValidacaoException;
import models.Cliente;
import models.Locacao;
import models.veiculos.Carro;
import models.veiculos.Moto;
import models.veiculos.Veiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LocacaoGrlMain {

    private static ClienteController clienteController;
    private static VeiculoController veiculoController;
    private static LocacaoController locacaoController;
    private static LojaDao lojaDao;

    /**
     * Inicializa os controllers que seram utlizados
     * para realizar operações sobre os dados
     */
    private static void inicializarControllers() {
        clienteController = new ClienteController();
        veiculoController = new VeiculoController();
        locacaoController = new LocacaoController();
    }

    public static void main(String args[]) {
        lojaDao = LojaDao.getInstance();
        try {
            lojaDao.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        inicializarControllers();
        apresentarMenu();
    }

    /**
     * Apresenta o menu com as opçoes que o usuário
     * pode selecionar
     */
    private static void apresentarMenu() {

        System.out.println("\n -------------- Escolha uma opção ------------------");

        System.out.println("\n1 -------------- Listar Veiculos");
        System.out.println("2 -------------- Listar Clientes");
        System.out.println("3 -------------- Listar Locações");

        System.out.println("\n4 -------------- Cadastrar Veiculos");
        System.out.println("5 -------------- Cadastrar Clientes");
        System.out.println("6 -------------- Cadastrar Locações");

        System.out.println("\n7 -------------- Editar Veiculos");
        System.out.println("8 -------------- Editar Clientes");
        System.out.println("9 -------------- Editar Locações");

        System.out.println("\n10 -------------- Remover Veiculos");
        System.out.println("11 -------------- Remover Clientes");
        System.out.println("12 -------------- Remover Locações");

        System.out.println("\n13 -------------- buscar Veiculos por placa");
        System.out.println("14 -------------- buscar Clientes por CPF");
        System.out.println("15 -------------- buscar Locações por CPF ou Placa");

        System.out.println("\n16 -------------- Calcular receita total das locações");

        System.out.println("\n0 -------------- Salvar e sair");

        try {
            lerRespostaDoUsuario();
        } catch (IOException e) {
            System.out.println("Houve um problema ao ler a resposta do usuário");
        }
    }

    /**
     * Metodo Responsável por ler a opção do menu
     * que o usuário selecionou
     */
    private static void lerRespostaDoUsuario() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;

        try {

            System.out.println("Digite o número referente a opção escolhida");
            opcaoEscolhida = in.readLine();
        } catch (IOException e) {
            System.out.println("Houve um problema ao ler a resposta do usuário");
        }

        if(opcaoEscolhida == null){
            System.out.println("Valor informado inválido, por favor escolha outra opção");
            apresentarMenu();
        } else {

            tratarRespostaDoUsuario(opcaoEscolhida);
        }
    }

    /**
     * Método responsável por tratar a resposta fornecida pelo usuário
     * @param opcaoEscolhida opção do menu escolhida pelo usuário
     */
    private static void tratarRespostaDoUsuario(String opcaoEscolhida) throws IOException {


        switch (opcaoEscolhida) {

            case "1":
                listar(Veiculo.class);
                break;
            case "2":
                listar(Cliente.class);
                break;
            case "3":
                listar(Locacao.class);
                break;
            case "4":
                cadastrarVeiculos();
                break;
            case "5":
                cadastrarClientes();
                break;
            case "6":
                cadastrarLocacao();
                break;
            case "7":
                editarVeiculos();
                break;
            case "8":
                editarCliente();
                break;
            case "9":
                editarLocacoes();
                break;
            case "10":
                removerVeiculos();
                break;
            case "11":
                removerCliente();
                break;
            case "12":
                removerLocacoes();
                break;
            case "13":
                buscarVeiculos();
                break;
            case "14":
                buscarCliente();
                break;
            case "15":
                buscarLocacoes();
                break;
            case "16":
                calcularReceitaTotalLocacoes();
                break;
            case "0":
                lojaDao.salvarDados();
                break;
            default:
                System.out.println("A opção informada é inválido");
        }

        if(!opcaoEscolhida.equals("0")) {
            apresentarMenu();
        }
    }

    private static void calcularReceitaTotalLocacoes() {
    }

    private static void buscarLocacoes() {
    }

    private static void buscarCliente() {
    }


    private static void buscarVeiculos() {
    }

    private static void removerLocacoes() {
    }

    private static void removerCliente() {
    }

    /**
     * Remove o veiculo cuja a placa
     * foi informada pelo usuário
     *
     * @throws IOException
     */
    private static void removerVeiculos() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;
        Veiculo veiculo = null;

        System.out.println("\n --------- Remoção de veículo --------- \n");

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a placa do veículo");
            opcaoEscolhida = in.readLine();
            veiculo = veiculoController.buscar(opcaoEscolhida);
            if(veiculo == null) {
                System.out.println("Não existe veiculo com a placa informada");
                opcaoEscolhida = null;
            }
        }

        veiculoController.deletar(veiculo);
    }

    /**
     * Permite trocar a data final de uma locação
     * em que a placa e o cpf do cliente forem informados
     * @throws IOException
     */
    private static void editarLocacoes() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;
        Locacao locacao = new Locacao();

        System.out.println("\n --------- Edição de locação --------- \n");

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a placa do veículo para edição da Locação");
            opcaoEscolhida = in.readLine();
            locacao.setVeiculo(veiculoController.buscar(opcaoEscolhida));
            if(locacao.getVeiculo() == null) {
                System.out.println("Não existe veiculo com a placa informada");
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o cpf do cliente para edição da Locação");
            opcaoEscolhida = in.readLine();
            locacao.setCliente(clienteController.buscar(opcaoEscolhida));
            if(locacao.getCliente() == null) {
                System.out.println("Não existe cliente com o cpf informado");
                opcaoEscolhida = null;
            }
        }

        Locacao locacaoEncontrada = locacaoController.buscar(locacao.getCliente().getCpf(), locacao.getVeiculo().getPlaca());

        if(locacaoEncontrada == null) {
            System.out.println("Não foi possivel encontrar uma locação com os dados informados");
            return;
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe uma nova data final para esta locação");
            opcaoEscolhida = in.readLine();
            locacaoEncontrada.setDataFim(opcaoEscolhida);
        }
    }



    /**
     * Edita um veiculo a partir de um
     * número de placa informada pela usuário
     * @throws IOException
     */
    private static void editarVeiculos() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;
        Veiculo veiculo = null;

        System.out.println("\n --------- Edição de veículo --------- \n");

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a placa do veículo para edição");
            opcaoEscolhida = in.readLine();
            veiculo = veiculoController.buscar(opcaoEscolhida);
            if(veiculo == null) {
                System.out.println("Não existe veiculo com a placa informada");
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe um novo nome para este veiculo");
            opcaoEscolhida = in.readLine();
            veiculo.setNome(opcaoEscolhida);
        }

    }


    /**
     * Altera o nome de um cliente no qual
     * o cpf foi informado pelo usuário
     * @throws IOException
     */
    private static void editarCliente() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;
        Cliente cliente = null;

        System.out.println("\n --------- Edição de cliente --------- \n");
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o cpf do cliente que deseja editar");
            opcaoEscolhida = in.readLine();
            cliente = clienteController.buscar(opcaoEscolhida);
            if(cliente == null) {
                System.out.println("Não existe cliente com o cpf informado");
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe um novo nome para este cliente");
            opcaoEscolhida = in.readLine();
            cliente.setNome(opcaoEscolhida);
        }
    }

    /**
     * Cadastra uma locação com os dados informados
     * pelo usuário
     * @throws IOException
     */
    private static void cadastrarLocacao() throws IOException {
        Locacao locacao = new Locacao();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;

        System.out.println("\n --------- Cadastro de Locação --------- \n");
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o cpf do cliente da locação");
            opcaoEscolhida = in.readLine();
            Cliente cliente = clienteController.buscar(opcaoEscolhida);
            if(cliente == null) {
                System.out.println("Não existe clientes com o cpf informado");
                opcaoEscolhida = null;
            }
            locacao.setCliente(cliente);
        }

        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a placa do veículo para locação");
            opcaoEscolhida = in.readLine();
            Veiculo veiculo = veiculoController.buscar(opcaoEscolhida);
            if(veiculo == null) {
                System.out.println("Não existe veiculo com a placa informada");
                opcaoEscolhida = null;
            }
            locacao.setVeiculo(veiculo);
        }

        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a data de inicio da locação");
            opcaoEscolhida = in.readLine();
            locacao.setDataInicio(opcaoEscolhida);
        }
        opcaoEscolhida = null;
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a data de fim da locação");
            opcaoEscolhida = in.readLine();
            locacao.setDataFim(opcaoEscolhida);
        }

        locacaoController.salvar(locacao);
    }


    /**
     * Metodo responsavel por realizar o cadastro de
     * clientes
     */

    private static void cadastrarClientes() throws IOException {
        Cliente cliente = new Cliente();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;

        System.out.println("\n --------- Cadastro de Clientes --------- \n");
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o cpf do cliente");
            opcaoEscolhida = in.readLine();
            cliente.setCpf(opcaoEscolhida);
            if(clienteController.buscar(opcaoEscolhida) != null) {
                System.out.println("Ja existe cliente com o cpf informado");
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o nome do cliente");
            opcaoEscolhida = in.readLine();
            cliente.setNome(opcaoEscolhida);
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {
            System.out.println("Por favor informe a profissao do cliente");
            opcaoEscolhida = in.readLine();
            cliente.setProfissao(opcaoEscolhida);
        }

        clienteController.salvar(cliente);

    }


    /**
     * Metodo responsavel por cadastrar um veiculo
     * com os dados informados pelo usuario
     */
    private static void cadastrarVeiculos() throws IOException {

        Veiculo veiculo = new Veiculo();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;

        System.out.println("\n --------- Cadastro de Veículos --------- \n");

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a placa do veículo");
            opcaoEscolhida = in.readLine();
            veiculo.setPlaca(opcaoEscolhida);
        }

        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o nome do veículo");
            opcaoEscolhida = in.readLine();
            veiculo.setNome(opcaoEscolhida);
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a marca do veículo");
            opcaoEscolhida = in.readLine();
            veiculo.setMarca(opcaoEscolhida);
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o ano de fabricação do veículo");
            opcaoEscolhida = in.readLine();
            try {
                veiculo.setAnoFabricacao(Integer.parseInt(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe a categoria do veículo(A,B,C OU D)");
            opcaoEscolhida = in.readLine();
            Categoria categoria = Categoria.getByCodigo(opcaoEscolhida);
            veiculo.setCategoria(categoria);
            if(categoria == null){
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o consumo do veículo em km/l.");
            opcaoEscolhida = in.readLine();
            try {
                veiculo.setKmPorLitro(Integer.parseInt(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe as cilindradas do veículo.");
            opcaoEscolhida = in.readLine();
            try {
                veiculo.setCilindradas(Integer.parseInt(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {

            System.out.println("Por favor informe o preço ao dia do veículo.");
            opcaoEscolhida = in.readLine();
            try {
                veiculo.setPrecoAoDia(Float.parseFloat(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }

        System.out.println("Por favor escolha o tipo de veiculo que deseja cadastrar (m---- Moto c --- Carro)");
        opcaoEscolhida = in.readLine();

        if(opcaoEscolhida.equals("m")){
            cadastrarMoto(veiculo);
        } else {
            cadastrarCarro(veiculo);
        }
    }


    /**
     * Cadastra um veiculo do tipo carro
     * com os dados informados na etapa de cadastro
     * de veiculos
     * @param veiculo dados base do veiculo que sera cadastrado
     */
    private static void cadastrarCarro(final Veiculo veiculo) throws IOException {
        Carro carro = new Carro();
        carro.setNome(veiculo.getNome());
        carro.setPlaca(veiculo.getPlaca());
        carro.setMarca(veiculo.getMarca());
        carro.setAnoFabricacao(veiculo.getAnoFabricacao());
        carro.setCategoria(veiculo.getCategoria());
        carro.setKmPorLitro(veiculo.getKmPorLitro());
        carro.setCilindradas(veiculo.getCilindradas());
        carro.setPrecoAoDia(veiculo.getPrecoAoDia());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;

        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {
            System.out.println("Digite o numero de portas do carro");
            opcaoEscolhida = in.readLine();
            try {
                carro.setNumeroDePortas(Integer.parseInt(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }
        opcaoEscolhida = null;
        while (opcaoEscolhida == null || opcaoEscolhida.isEmpty()) {
            System.out.println("Digite o numero máximo de passageiros do carro");
            opcaoEscolhida = in.readLine();
            try {
                carro.setNumeroMaxPassageiros(Integer.parseInt(opcaoEscolhida));
            } catch (NumberFormatException nf) {
                opcaoEscolhida = null;
            }
        }

        System.out.println("O carro possui ar condicionado ? S -- Sim N -- Não");
        opcaoEscolhida = in.readLine();
        carro.setArCondicionado(opcaoEscolhida != null && opcaoEscolhida.toUpperCase().equals("S"));

        System.out.println("O carro possui vidros elétricos ? S -- Sim N -- Não");
        opcaoEscolhida = in.readLine();
        carro.setVidroEletricos(opcaoEscolhida != null && opcaoEscolhida.toUpperCase().equals("S"));

        try {
            veiculoController.salvar(carro);
        } catch (ValidacaoException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Cadastra um veiculo do tipo moto
     * com os dados informados na etapa de cadastro
     * de veiculos
     * @param veiculo dados base do veiculo que sera cadastrado
     */
    private static void cadastrarMoto(Veiculo veiculo) throws IOException {
        Moto moto = new Moto();
        moto.setNome(veiculo.getNome());
        moto.setPlaca(veiculo.getPlaca());
        moto.setMarca(veiculo.getMarca());
        moto.setAnoFabricacao(veiculo.getAnoFabricacao());
        moto.setCategoria(veiculo.getCategoria());
        moto.setKmPorLitro(veiculo.getKmPorLitro());
        moto.setCilindradas(veiculo.getCilindradas());
        moto.setPrecoAoDia(veiculo.getPrecoAoDia());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String opcaoEscolhida = null;
        System.out.println("A moto possui Bau ? S -- Sim N -- Não");
        opcaoEscolhida = in.readLine();
        moto.setPossuiBau(opcaoEscolhida != null && opcaoEscolhida.toUpperCase().equals("S"));

        System.out.println("A moto possui partida elétrica ? S -- Sim N -- Não");
        opcaoEscolhida = in.readLine();
        moto.setPartidaEletrica(opcaoEscolhida != null && opcaoEscolhida.toUpperCase().equals("S"));

        System.out.println("A moto possui partida eletrica ? S -- Sim N -- Não");
        opcaoEscolhida = in.readLine();
        moto.setTravaParaCapacete(opcaoEscolhida != null && opcaoEscolhida.toUpperCase().equals("S"));

        try {
            veiculoController.salvar(moto);
        } catch (ValidacaoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Classe responsável por listar Objetos a
     * partir de determinada classe
     * @param classe Classe do objeto que sera listado
     *
     */
    private static void listar(Class classe) {

        List<?> listDeObjetos;

        if(classe == Cliente.class){
            listDeObjetos = clienteController.listar();
        } else if(classe == Veiculo.class){
            listDeObjetos = veiculoController.listar();
        }else if(classe == Locacao.class) {
            listDeObjetos = locacaoController.listar();
        } else {
            throw new IllegalArgumentException("Tipo de objeto para a listagem é inválido");
        }

        if(listDeObjetos.size() == 0) {
            System.out.println("Não existem "+classe.getSimpleName()+"(s) cadastrados");
        } else {
            for(Object objetoDaLista : listDeObjetos) {
                System.out.println(objetoDaLista.toString());
            }
        }
    }

}
