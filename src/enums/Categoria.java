package enums;

/**
 * Enum que representa as diferentes
 * categorias que um veiculo pode ser.
 */
public enum Categoria {

    A("Super Luxo"),
    B("Luxo"),
    C("Passeio"),
    D("Popular");

    private String nome;

    Categoria(String nome){
        this.nome = nome;
    }

}
