package entify;

public class usuario {
    private int codigo;
    private String nome;
    private String  cpf;
    private String  saldoInicial;
    private String  credito;

   public int getcodigo(){
        return  codigo;
   }

   public void setcodigo(int codigo){
        this.codigo = codigo;
   }

    public String getNome() {
        return nome;
    }

   public void setnome(String nome){
        this.nome = nome;
   } 

   public String getcpf() {
    return cpf;
    }

    public void setcpf(String cpf){
    this.cpf = cpf;
    } 

    public String saldoinicial() {
    return saldoInicial;
    }

    public void setsaldoinicial(String saldoinicial){
    this.saldoInicial = saldoinicial;
    } 
    public String credito() {
        return credito;
    }
    public void setcredito(String credito){
        this.credito = credito;
    } 

    public String getsaldoInicial() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
