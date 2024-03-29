package servidor;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.BD.ConsultaDAO;
import servidor.BD.ExameDAO;
import servidor.BD.ExameMarcadoDAO;
import servidor.BD.FuncionarioDAO;
import servidor.BD.MedicoDAO;
import servidor.BD.PacienteDAO;
import servidor.BD.ProntuarioDAO;
import servidor.entidades.Atestado;
import servidor.entidades.Consulta;
import servidor.entidades.Exame;
import servidor.entidades.ExameMarcado;
import servidor.entidades.Funcionario;
import servidor.entidades.Medico;
import servidor.entidades.Paciente;
import servidor.entidades.Prontuario;
import servidor.entidades.Receita;



public class Servidor extends Thread {
    
    Conexao conexao;
    MedicoDAO md;
    FuncionarioDAO fd;
    ExameDAO ed;
    PacienteDAO pd;
    ProntuarioDAO pdd;
    ConsultaDAO cd;
    ExameMarcadoDAO edd;
    public Servidor(Socket cliente) throws IOException {
        this.conexao = new Conexao(cliente);
        this.md = new MedicoDAO();
        this.fd = new FuncionarioDAO();
        this.ed = new ExameDAO();
        this.pd = new PacienteDAO();
        this.pdd = new ProntuarioDAO();
        this.cd = new ConsultaDAO();
        this.edd = new  ExameMarcadoDAO();
    }

    @Override
    public void run() {
       
        while(true){
            try {
                String op;
                String[] funcao;
                op = conexao.receber();
                funcao = op.split("@");
                switch(funcao[0]){
                    case "TelaLogin":                       
                        telalogin(funcao);                        
                        break;
                    case "CadastrarMedico":
                        cadastraMedico(funcao);
                        break;
                    case "RemoverMedico":
                        removerMedico(funcao);
                        break;
                    case "BuscarMedico":
                        buscarMedico(funcao);
                        break;
                    case "AlterarMedico":
                        alteraMedico(funcao);
                        break;
                    case "CadastrarFuncionario":
                        cadastrarFuncionario(funcao);
                        break;
                    case "RemoverFuncionario":
                        removerFuncionario(funcao);
                        break;
                    case "BuscarFuncionario":
                        buscarFuncionario(funcao);
                        break;
                    case "AlterarFuncionario":
                        alterarFuncionario(funcao);
                        break;
                    case "AdicionaExame":
                        adicionaExame(funcao);
                        break;
                    case "RemoverExame":
                        removerExame(funcao);
                        break;
                    case "BuscarPaciente":
                        buscarPaciente(funcao);
                        break;
                    case "BuscarProntuario":
                        buscarProntuario(funcao);
                        break;
                    case "BuscarProntuarioPaciente":
                        buscarProntuarioPaciente(funcao);
                        break;
                    case "AlterarProntuario":
                        alterarProntuario(funcao);
                        break;
                    case "Receita":
                        imprimirReceita(funcao);
                        break;
                    case "Atestado":
                        imprimirAtestado(funcao);
                        break;
                    case "Agenda":
                        consultasDoDia(funcao);
                        break;       
                    case "consultaAtendida":
                        consultaAtendida(funcao);
                        break;
                    case "CadastrarPaciente":
                        cadastrarPaciente(funcao);
                        break;
                    case "AlterarPaciente":
                        alterarPaciente(funcao);
                        break;
                    case "AgendarConsulta":
                        agendarConsulta(funcao);
                        break;
                    case "BuscarConsulta":
                        buscarConsulta(funcao);
                        break;
                    case "ConfirmarConsulta":
                        confirmarConsulta(funcao);
                        break;
                    case "AgendarExame":
                        agendarExame(funcao);
                        break;
                    case "BuscarExameMarcado":
                        buscarExameMarcado(funcao);
                        break;
                    case "ConfirmarExame":
                        confirmarExame(funcao);
                        break;
                    case "BuscaExamesImprimir":
                        buscaExamesImprimir(funcao);
                        break;
                    case "ImprimirExame":
                        imprimirExame(funcao);
                        break;
                }
            } catch (IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    private synchronized void telalogin(String[] funcao) throws IOException, SQLException {
       
        String tipoUsuario = funcao[3];
        switch(tipoUsuario){
            case "Mestre":                   
                if(fd.validaLogin(funcao[1], funcao[2])){    
                  
                    conexao.enviar("mestre");
                }else{
                    conexao.enviar("erro");
                }
               
                break;
            case "Funcionario":
                FuncionarioDAO f = new FuncionarioDAO();
                if(f.validaLogin(funcao[1], funcao[2])){                    
                    conexao.enviar("funcionario");
                }else{
                    conexao.enviar("erro");
                }
                break;
            case "Medico":
                if(md.validaLogin(funcao[1], funcao[2])){                    
                    conexao.enviar("medico");
                }else{
                    conexao.enviar("erro");
                }
                break;
            case "Paciente":
                PacienteDAO p = new PacienteDAO();
                if(p.validaLogin(funcao[1], funcao[2])){                    
                    conexao.enviar("paciente");
                }else{
                    conexao.enviar("erro");
                }
                break;
        }
    }

  
    private synchronized void cadastraMedico(String[] funcao) throws ClassNotFoundException{
        try {
            Medico medico = new Medico(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5]);            
            if(md.adcMedico(medico)){
                conexao.enviar("ok");
            }else{
                conexao.enviar("jaexiste");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void removerMedico(String[] funcao) {
        try{
            if(md.removeMedico(funcao[1])){            
                conexao.enviar("ok");            
            }else{
                conexao.enviar("naoencontrado");
            }    
        } catch (IOException | SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    private synchronized void buscarMedico(String[] funcao) {       
        try {            
            String dados = md.getM(funcao[1]);
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }       
    private synchronized void alteraMedico(String[] funcao) {
        Medico medico = new Medico(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5]); 
        try {
            if(md.atualizaMedico(medico)){            
                conexao.enviar("ok");            
            }else{
                conexao.enviar("userjaexiste");
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private synchronized void cadastrarFuncionario(String[] funcao) {
        Funcionario f = new Funcionario(funcao[1], funcao[2], funcao[3], funcao[4]);
        try{
            if(fd.adcFuncionario(f)){
                conexao.enviar("ok");
            }else{
                conexao.enviar("jaexiste");
            }
        }catch(IOException | SQLException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private synchronized void removerFuncionario(String[] funcao) {
       try{
            if(fd.removeFuncionario(funcao[1])){            
                conexao.enviar("ok");            
            }else{
                conexao.enviar("naoencontrado");
            }    
        } catch (IOException | SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    private synchronized void buscarFuncionario(String[] funcao) {
        try {            
            String dados = fd.getF(funcao[1]);
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private synchronized void alterarFuncionario(String[] funcao) {
        Funcionario f = new Funcionario(funcao[1], funcao[2], funcao[3], funcao[4]);
        try{
            if(fd.atualizaFuncionario(f)){
                conexao.enviar("ok");
            }else{
                conexao.enviar("jaexiste");
            }
        }catch(IOException | SQLException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void adicionaExame(String[] funcao) {
        Exame e = new Exame(funcao[1], Double.parseDouble(funcao[2]));
        try{
            if(ed.adcExame(e)){
                conexao.enviar("ok");
            }else{            
                conexao.enviar("jaexiste");            
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Criar o metodo removerExame na ExameDAO retornando true caso tenha sido removido ou falso caso nao tenha sido encontrada
    private synchronized void removerExame(String[] funcao) {
        try{
            if(ed.removeExame(funcao[1])){
                conexao.enviar("ok");
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Alterar a getp no PacienteDAO para retornar null caso nao tenha encontradoo
    //Retirar dar DAO tambem o campo Identificacao (Nao tem mais, tira do BD tbm) e adicionar depois do municipio o campo cep
    private synchronized void buscarPaciente(String[] funcao) {
        try {
            String dados = pd.getP(funcao[1]);
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void buscarProntuario(String[] funcao) {
        try{
            String dados = pdd.getProntuario(funcao[1]);
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo igual ao de cima, mas deve procurar pelo nome de usuario
    private synchronized void buscarProntuarioPaciente(String[] funcao) {
        try{
            String dados = pdd.getP(funcao[1]);
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Criar classe prontuario, os atributos tu olha na tela "BuscarProntuario". A ordem pro construtor é:  queixaprincipal, historicofamiliar,
    //obs, altura, peso, hemogucloteste, temperatura, frequenciacardiaca, pressaosistotica, pressaodiastolica, obs2, cpf do Paciente.
    //Criar tambem a ProntuarioDAO.
    //Nao vai ter metodo pra adicionar entao tu vai fazer uma condição. Se ja existe um prontuario cadastrado no cpf do Paciente tu atualiza, se não, adiciona.
    private synchronized void alterarProntuario(String[] funcao) throws SQLException, IOException {
        Prontuario p = new Prontuario(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5],funcao[6], funcao[7], funcao[8], funcao[9], funcao[10], funcao[11],funcao[12]);
        pdd.atualizaProntuario(p);
        conexao.enviar("ok");
 
    }

    // OK
    private synchronized void imprimirReceita(String[] funcao) {
        try {
            String dados = pd.getP(funcao[1]);
            Receita r = new Receita(funcao[1], funcao[2]);
            if(dados != null){               
                conexao.enviar(r.toString());
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
   //OK 
    private synchronized void imprimirAtestado(String[] funcao) {
        try {
            String dados = pd.getP(funcao[1]);
            Atestado a = new Atestado(funcao[1],funcao[2],funcao[3],funcao[4]);
            if(dados != null){                
                conexao.enviar(a.toString());
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    // Fazer um metodo para retornar toda a tabela de consultas de acordo com o dia. Recebe a data e retorna todos os registros encontrados naquela data
    //Padrao de retorno "DADO1@DADO2@DADO3@DADO4%DADO1@DADO2@DADO3@DADO4
    //Separar cada linha por % e cada dado por @
    private synchronized void consultasDoDia(String[] funcao) {
        try {
            String tabela = cd.getConsultasDoDia(funcao[1]);
            conexao.enviar(tabela);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Altera o campo "Atendido" da consulta para "ok". Recebe o id da consulta. Retorna true se encontrou e alterou
    private synchronized void consultaAtendida(String[] funcao) throws SQLException, IOException {
        if(cd.alteraAtendimento(Integer.parseInt(funcao[1]))){
            conexao.enviar("ok");
        }else{
            conexao.enviar("naoencontrado");
        }
    }

    //Alterar a cadastrar Paciente pra retornar true ou falso caso ja exista.
    //Retirar campo de identificação e adicionar CEP depois do municipio no DAO e Paciente
    private synchronized void cadastrarPaciente(String[] funcao) {
        try {
            //Altera construtor de paciente para a ordem: nome, datanascimento, endereco, bairro, municipio, cep, estado, telefone, celular, cpf, user, senha
            Paciente p = new Paciente(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5], funcao[6], funcao[7], funcao[8], funcao[9], funcao[10], funcao[11], funcao[12]);
            if(pd.adcPaciente(p)){                
                conexao.enviar("ok");                
            }else{
                conexao.enviar("jaexiste");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Tira o campo id do construtor de consulta e coloca nessa ordem: especialista, cpf, telefone, data, horario, obs, status
    // Retorna true se cadastrar e retorna false caso ja tenha um registro cadastrado na mesma data e hora.
    private synchronized void agendarConsulta(String[] funcao) throws SQLException {
        Consulta c = new Consulta(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5], funcao[6], funcao[7]);
        try{
            if(cd.adcConsulta(c)){
                conexao.enviar("ok");
            }else{           
                conexao.enviar("datahorario");            
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Altera a getC na DAO pra receber string(cpf) e retorna todas os registros encontrados daquele CPF
    //Padrao de retorno "DADO1@DADO2@DADO3@DADO4%DADO1@DADO2@DADO3@DADO4
    //Separar cada linha por % e cada dado por @
    private  synchronized void buscarConsulta(String[] funcao) {
        try{
            String dados = cd.getC(Integer.parseInt(funcao[1]));
            if(dados != null){
                conexao.enviar(dados);
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Criar metodo na DAO que altera o campo status para "ok" de acordo com o id da consulta que ela recebe.    
    private synchronized void confirmarConsulta(String[] funcao) throws SQLException {
        try{
            if(cd.confirmaConsulta(Integer.parseInt(funcao[1]))){
                conexao.enviar("ok");
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Retirar o campo id do construtor no ExameMarcado.
    //Retorna true se foi agendado com sucesso e retorna falso se ja tiver algum exame marcado para aquela data-horario.
    private synchronized void agendarExame(String[] funcao) throws SQLException, IOException {
        ExameMarcado e = new ExameMarcado(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5], funcao[6]);
        if(edd.adcExameMarcado(e)){
            conexao.enviar("ok");
        }else{
            conexao.enviar("datahorario");
        }
    }

    //Altera a funcao getExameMarcado para retornar todos os registros de acordo com o cpf que esta sendo enviado.
     //Padrao de retorno "DADO1@DADO2@DADO3@DADO4%DADO1@DADO2@DADO3@DADO4
    //Separar cada linha por % e cada dado por @
    private synchronized void buscarExameMarcado(String[] funcao) throws SQLException {
        try{
            String dados;
            dados = edd.getEM(Integer.parseInt(funcao[1]));
            conexao.enviar(dados);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }

    //Alterar o campo de status para "confirmado" do exame de acordo com o id que é enviado
    private synchronized void confirmarExame(String[] funcao) throws IOException, SQLException {
        if(edd.confirmaExame(Integer.parseInt(funcao[1]))){
            conexao.enviar("ok");
        }else{
            conexao.enviar("naoencontrado");
        }
    }
    //Retornar todos os Exames de acordo com o cpf que é enviado
    //Padrao de retorno "DADO1@DADO2@DADO3@DADO4%DADO1@DADO2@DADO3@DADO4
    //Separar cada linha por % e cada dado por @
    private synchronized void buscaExamesImprimir(String[] funcao) throws SQLException {
        try{
            String dados = edd.getEM(Integer.parseInt(funcao[1]));
            conexao.enviar(dados);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Retorna exame de acordo com id que é enviado.
    private synchronized void imprimirExame(String[] funcao) throws SQLException {
        try {            
            if(edd.buscaExame(Integer.parseInt(funcao[1]))){
                conexao.enviar("ok");
            }else{
                conexao.enviar("naoencontrado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private synchronized void alterarPaciente(String[] funcao) throws SQLException {
        try{
            Paciente p = new Paciente(funcao[1], funcao[2], funcao[3], funcao[4], funcao[5], funcao[6], funcao[7], funcao[8], funcao[9], funcao[10], funcao[11], funcao[12]);
            if(pd.atualizaPaciente(p)){
                conexao.enviar("ok");
            }else{
                conexao.enviar("jaexiste");
            }
        }catch(IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
