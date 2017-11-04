package enums;

/**
 * Enum que representa as diferentes
 * categorias que um veiculo pode ser.
 */
public enum Categoria {

    A("Super Luxo","A"),
    B("Luxo","B"),
    C("Passeio","C"),
    D("Popular","D");

    private String nome;
    private String codigo;

    Categoria(String nome,String codigo){

        this.nome = nome;
        this.codigo = codigo;
    }

    /**
     * Retorna um Enum de categoria a partir de um
     * código informado
     * @param codigo codigo da categoria a ser buscada
     * @return Categoria
     */
    public static Categoria getByCodigo(String codigo) {
        codigo = codigo.toUpperCase();
        for(Categoria categoria: Categoria.values()){
            if(categoria.codigo.equals(codigo)){
                return categoria;
            }
        }
        return null;
    }
}
