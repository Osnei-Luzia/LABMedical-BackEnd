# LABMedical BackEnd
## _Gestão Hospitalar_

LABMedical BackEnd é uma API Rest para o sistema FrontEnd LABMedical, designado para fazer a comunicação com o banco de dados, foi construido com Spring, em Java, e pode facilmente alterar seu banco relacional.

### Sumário

1. [Funcionalidades](#funcoes)
2. [Tecnologias](#tech)
3. [Instalação](#install)
4. [Melhorias](#melhorias)

<br>
<a id="funcoes"></a>
## Funcionalidades

Sendo uma API Rest, o LABMedical BackEnd esta preparado para receber requisições HTTP para cadastros(POSTs), consultas(GETs), alterações(PUTs) ou remoções(DELETEs) no banco de dados. Além de uma contagem da quantidade de registros.
A API está em modo de teste, então possui registros fictícios(seeders) inclusos no código e o banco de dados está configurado para "Create-Drop", o que resulta em uma limpeza do banco em sua inicialização, criação de novas tabelas, população destas tabelas. E ao encerrar a aplicação, os tabelas são mais uma vez finalizadas.
Também está incluso em seus arquivos, uma coleção de requests para teste em formato JSON, este pode ser usado por exemplo com o Postman.

- Cadastro de Usuários(médicos), Pacientes, Consultas, Exames e Endereços.
- Consultas de Pacientes, Exames, Consultas e Endereços. 
- Listagem da quantidade de registros de Pacientes, Exames e Consultas.
- Possui uma base de dados(seeders) para testes, inclusa no código.
- Está configurado para limpeza do banco tanto na inicialização quanto encerramento da aplicação.
- Possui uma coleção de requests JSON para testes.
- Todas as inserções possuem mensagens de erro legíveis ao usuário.

1. [Cadastros](#cadastros)
1.1 [Cadastro de Usuário](#cadastroUsuario)
1.2 [Cadastro de Paciente](#cadastroPaciente)
1.3 [Cadastro de Exames](#cadastroExame)
1.4 [Cadastro de Endereços](#cadastroEndereco)
2. [Consultas](#consultas)
2.1 [Consulta de Pacientes](#consultaPaciente)
2.2 [Consulta de Consultas](#consultaConsulta)
2.3 [Consulta de Exames](#consultaExame)
2.4 [Consulta de Endereços](#consultaEndereco)
2.5 [Consulta de Estatísticas](#consultaEstatisticas)
3. [Atualizações](#atualizacao)
3.1 [Atualização de Usuários](#atualizacaoUsuario)
3.2 [Atualização de Pacientes](#atualizacaoPaciente)
3.3 [Atualização de Consultas](#atualizacaoConsulta)
4. [Deleção](#delecao)
4.1 [Deleção de Pacientes](#delecaoPaciente)
4.2 [Deleção de Consultas](#delecaoExame)
4.3 [Deleção de Exames](#delecaoConsulta)

<br>
<a  id="cadastros"></a>
### Cadastros
É possível o cadastro de Usuários(médicos), Pacientes, Consultas, Exames e Endereços. Todos devem vir por HTTP Requests de POST com corpo no formato JSON e todos recebem um Response com os dados recém cadastrados.
<br>
<a  id="cadastroUsuario"></a>
#### Cadastro de Usuários
O LABMedical BackEnd pode cadastrar Usuários por meio de requests POST no endereço "../api/usuarios", em formato JSON.
Todos os campos são obrigatórios no cadastro de um usuário, sendo eles: Nome Completo, Genero, Data de Nascimento, CPF, RG, Estado Civil, Telefone, E-mail, Naturalidade, CRM, Especialização e Senha.

- O campo Data de Nascimento deve ser preenchido por uma data válida e dentro do formato "dd/mm/aaaa".
- O campo CPF deve ser preenchido por um CPF válido.
- O campo Estado Civil deve ser preenchido pelas seguintes opções: "SOLTEIRO", "CASADO", "SEPARADO", "DIVORCIADO", "VIUVO". Ou pela sua correspondência numérica, na mesma ordem, de 0 a 4.
- O campo E-mail deve ser preenchido por um e-mail válido no formato "exemplo@exemplo.com".
- O campo Especialização deve ser preenchido pelas seguintes opções: "CLINICO_GERAL", "ANESTESISTA", "DERMATOLOGIA", "GINECOLOGIA", "NEUROLOGIA", "PEDIATRIA", "PSIQUIATRIA", "ORTOPEDIA". Ou pela sua correspondência numérica, na mesma ordem, de 0 a 7.
- O campo Senha deve conter no mínimo 8 caractéres e apenas caractéres alfanuméricos.

Exemplo do Request em JSON:
```
{
	"nomeCompleto": "Olivia Luciana Freitas",
	"genero": "Feminino",
	"dataNascimento": "13/12/1313",
	"cpf": "664.097.772-99",
	"rg": "24.119.173-7",
    "estadoCivil":4,
	"telefone": "(61) 2741-8782",
	"email": "olivia_freitas@gradu.if.ufrj.br",
    "naturalidade":"Brasileiro",
    "crm":"CRM/SP 124456",
    "especializacao":1,
	"senha": "O3OPges3nY"
}
```
<br>

<a  id="cadastroPaciente"></a>
#### Cadastro de Pacientes
O cadastro de Pacientes é feito por meio de requests POST no endereço "../api/pacientes", em formato JSON.
Os campos obrigatórios no cadastro de um paciente são: Nome Completo, Genero, Data de Nascimento, CPF, RG, Estado Civil, Telefone, E-mail, Naturalidade, Contato de Emergência, Id de Endereço.
Os campos não obrigatórios são: Lista de Alergias, Lista de Cuidados, Convênio, Número da Carteira do Convênio, Validade do Convênio.

- O campo Data de Nascimento deve ser preenchido por uma data válida e dentro do formato "dd/mm/aaaa".
- O campo CPF deve ser preenchido por um CPF válido.
- O campo Estado Civil deve ser preenchido pelas seguintes opções: "SOLTEIRO", "CASADO", "SEPARADO", "DIVORCIADO", "VIUVO". Ou pela sua correspondência numérica, na mesma ordem, de 0 a 4.
- O campo E-mail deve ser preenchido por um e-mail válido no formato "exemplo@exemplo.com".
- O campo Id de Endereço deve ser preenchido com um número correspondente a um registro de endereço previamente cadastrado no sistema.
- Ambas as listas recebem uma lista de textos, então seus registros devem ser feitos por um array de strings como demonstrado no exemplo do request.
- O campo Validade do Convênio deve ser uma data válida e dentro do formato "dd/mm/aaaa"

Exemplo do Request em JSON:
```
{
	"nomeCompleto": "Ruan Márcio Viana",
	"genero": "Masculino",
	"dataNascimento": "12/12/2222",
	"cpf": "034.049.590-19",
	"rg": "24.175.545-1",
    "estadoCivil":3,
	"telefone": "(19) 3722-2241",
	"email": "ruan_viana@diebold.com",
    "naturalidade":"Brasileiro",
    "listaAlergias":["Alergia 1", "Alergia 2"],
    "listaCuidados":["Cuidado 1", "Cuidado 2"],
    "contatoEmergencia":"(19) 3557-4456",
    "convenio":"Unimed",
    "numeroCarteira":"12413",
    "validade":"20/12/2040",
    "endereco":
    {
        "id":1
    }
}
```
<br>

<a  id="cadastroExame"></a>
#### Cadastro de Exames
O cadastro de Exames é feito por meio de requests POST no endereço "../api/exames", em formato JSON.
Os campos obrigatórios no cadastro de um exame são: Nome, Data e Hora, Tipo, Laboratório, Resultado, Id de paciente e Id de Usuário.
Os campos não obrigatórios são: Arquivo do Exame.

- O campo de Data e Hora é preenchido automáticamente pelo sistema após a verificação de todos os outros campos, este fica como uma marcação de tempo no momento do cadastro.
- O campo de Id de Paciente deve ser preenchido com um número correspondente a um registro de paciente previamente cadastrado.
- O campo de Id de Usuario deve ser preenchido com um número correspondente a um registro de usuario previamente cadastrado.
- O campo de Arquivo do Exame se preenchido, deve ser apenas a URL de um arquivo.

Exemplo do Request em JSON:
```
{
    "nome":"Nome do exame",
    "tipo":"Tipo de exame",
    "laboratorio":"Laboratorio",
    "arquivo":"/url/arquivo.pdf",
    "resultado":"Resultados do exames",
    "paciente_id":
    {
        "id":4
    },
    "usuario_id":
    {
        "id":2
    }
}
```
<br>
<a  id="cadastroEndereco"></a>
#### Cadastro de Endereços
O cadastro de Endereços é feito por meio de requests POST no endereço "../api/enderecos", em formato JSON.
Os campos obrigatórios no cadastro de um endereço são: CEP, Cidade, Estado, Logradouro, Número, Bairro.
Os campos não obrigatórios são: Complemento e Ponto de Referência.

Exemplo do Request em JSON:
```
{
    "cep": "70687-110",
	"cidade": "Brasília",
	"estado": "DF",
	"logradouro": "Quadra SQNW 309 Bloco B",
	"numero": 770,
    "complemento":"complemento",
	"bairro": "Setor Noroeste",
    "pontoReferencia":"Esquina"
}
```
<br>
<a id="consultas"></a>
### Consultas
É possível consultar os registros de Pacientes, Consultas, Exames, uma contagem dos mesmos, além da Consulta de Endereços. Todos devem vir por HTTP Requests de GET sem a necessidade de um corpo em JSON.
<br>
<a id="consultaPaciente"></a>
#### Consulta de Pacientes
A consulta de Pacientes pode ser feita de três maneiras: Buscar todos, Buscar por Nome, Buscar por Id. Todas são feitas por Requests de GET e recebem uma resposta em JSON.

- A consulta de todos os pacientes é feita pelo endereço "../api/pacientes".
- A consulta por Nome dos pacientes é feita pelo endereço "../api/pacientes", mas requer um parâmetro "nome" na URL, por exemplo "../api/pacientes?nome=Maitê Malu Rocha"
- A consulta por Id requer um número correspondente a um id de paciente gerado pelo sistema como caminho da URL, por exemplo "../api/pacientes/2"


Exemplo do Response em JSON:
```
{
        "id": 3,
        "nomeCompleto": "Maitê Malu Rocha",
        "genero": "Feminino",
        "dataNascimento": "21/02/1978",
        "cpf": "413.796.492-00",
        "rg": "27.594.616-2",
        "estadoCivil": "DIVORCIADO",
        "telefone": "(61) 98222-9417",
        "email": "maite_rocha@picolotoengenharia.com.br",
        "naturalidade": "Brasileiro",
        "listaAlergias": [
            "Alergia 1",
            "Alergia 2",
            "Alergia 3"
        ],
        "listaCuidados": [
            "Cuidado 2",
            "Cuidado 1"
        ],
        "contatoEmergencia": "(61) 3850-9502",
        "convenio": "Unimed",
        "numeroCarteira": "2543",
        "validade": "20/12/2033",
        "endereco": {
            "id": 1,
            "cep": "75102-075",
            "cidade": "Anápolis",
            "estado": "GO",
            "logradouro": "Rua AV 12",
            "numero": 920,
            "complemento": "Esquina com Rua 1001",
            "bairro": "Residencial Anaville",
            "pontoReferencia": "Esquina"
        },
        "exames": [
            2,
            4
        ]
    }
```
<br>
<a id="consultaConsulta"></a>
#### Consulta de Consultas
A consulta de Consultas pode ser feita apenas por Id com Requests de GET  no endereço "../api/consultas/{id}" e recebem uma resposta em JSON.

Exemplo do Response em JSON:
```
{
    "id": 1,
    "motivo": "Motivo da Consulta",
    "dataHora": "2023-04-27T19:22:28.841+00:00",
    "descricao": "Descrição da consulta",
    "medicacao": "Medicações",
    "dosagens": "Dosagens",
    "paciente_id": 3,
    "usuario_id": 1
}
```
<br>
<a id="consultaExame"></a>
#### Consulta de Exames
A consulta de Exames pode ser feita apenas por Id com Requests de GET  no endereço "../api/exames/{id}" e recebem uma resposta em JSON.

Exemplo do Response em JSON:
```
{
    "id": 3,
    "nome": "Nome do Exame",
    "dataHora": "2023-12-22T17:55:23.642+00:00",
    "tipo": "Tipo de Exame",
    "laboratorio": "Laboratório 4",
    "arquivo": "url/arquivo.pdf",
    "resultado": "Resultados de exame",
    "paciente_id": 4,
    "usuario_id": 2
}
```
<br>

<a id="consultaEnderecos"></a>
#### Consulta de Endereços
A consulta de Endereços é feita por Requests GET no endereço "../api/enderecos", e retorna uma resposta em JSON com todos os registros.

Exemplo do Response em JSON:
```
{
        "id": "1",
        "cep": "75102-075",
        "cidade": "Anápolis",
        "estado": "GO",
        "logradouro": "Rua AV 12",
        "numero": 920,
        "complemento": "Esquina com Rua 1001",
        "bairro": "Residencial Anaville",
        "pontoReferencia": "Esquina"
    }
```
<br>
<a id="consultaEstatisticas"></a>
#### Consulta de Estatísticas
A consulta de estatísticas pode ser feita por Request GET no endereço "../api/estatisticas" e recebe a quantidade de pacientes, consultas e exames cadastrados em formato JSON.

Exemplo do Response em JSON:
```
{
    "pacientes": 2,
    "consultas": 4,
    "exames": 4
}
```
<br>
<a id="atualizacao"></a>
### Atualização
É possível realizar alterações nos registros de Usuários(médicos), Pacientes, Consultas e Exames. Todas devem vir por HTTP Requests de PUT com corpo no formato JSON.
<br>

<a id="atualizacaoUsuario"></a>
#### Atualização de Usuários
A alteração de dados de Usuários é dividida em dois endereços, ambos requerem um número para Id correspondente á um registro de usuário dentro do sistema como caminho na URL, por exemplo "../api/usuarios/{id}". Um endereço serve únicamente para alteração de senha e outro para os demais campos.

- Alteração do campo senha é feita no endereço: "../api/usuarios/{id}/senha"
- Alteração dos demais campos é feita no endereço: "../api/usuarios/{id}"

Todos os campos obrigatórios do cadastro de usuário ainda são obrigatórios na alteração, porém, caso não haja interesse em alterar certos campos, é possível a omissão dos mesmos para mantê-los sem alteração.

Em caso de sucesso, é enviado um response com todos os dados do usuário que tenha sido alterado.

Exemplo do Request em JSON para o campo senha:
```
{
	"senha": "12a2s12w4d3"
}
```

Exemplo do Request em JSON para os demais campos, comparado com o request de cadastro,  alguns campos estão omitidos:
```
{
	"nomeCompleto": "Olivia Luciana Freitas",
	"genero": "Feminino",
	"dataNascimento": "12/12/2000",
	"telefone": "(61) 2741-8782",
    "naturalidade":"Brasileiro",
    "especializacao":5
}
```
<br>
<a id="atualizacaoPaciente"></a>
#### Atualização de Pacientes
A alteração de dados de Pacientes é feita no endereço "../api/pacientes/{id}" e requer um número correspondente ao id de paciente previamente cadastrado no sistema como caminho da URL.

Todos os campos obrigatórios do cadastro de paciente ainda são obrigatórios na alteração, porém, caso não haja interesse em alterar certos campos, é possível a omissão dos mesmos para mantê-los sem alteração.

Em caso de sucesso, é enviado um response com todos os dados do paciente que tenha sido alterado.

Exemplo do Request em JSON, comparado com o request de cadastro,  alguns campos estão omitidos:
```
{
	"nomeCompleto": "Mudado",
	"genero": "Masculino",
	"dataNascimento": "20/12/1980",
	"telefone": "(19) 3722-2241",
	"email": "ruan_viana@diebold.com",
    "listaAlergias":["outra alergia"],
    "listaCuidados":[],
    "contatoEmergencia":"(19) 3557-4456",
    "numeroCarteira":"12413",
    "validade":"20/12/2020",
    "endereco":
    {
        "id":4
    }
}
```
<br>
<a id="atualizacaoConsulta"></a>
#### Atualização de Consultas
A alteração de dados de Consultas é feita no endereço "../api/consultas/{id}" e requer um número correspondente ao id de consulta previamente cadastrada no sistema como caminho da URL.

Todos os campos obrigatórios do cadastro de consulta ainda são obrigatórios na alteração, porém, caso não haja interesse em alterar certos campos, é possível a omissão dos mesmos para mantê-los sem alteração.

Em caso de sucesso, é enviado um response com todos os dados da consulta que tenha sido alterada.

Exemplo do Request em JSON, comparado com o request de cadastro,  alguns campos estão omitidos:
```
{
    "motivo":"Mudado",
    "descricao":"Descrição",
    "dosagens":"Dosagens",
    "paciente_id":
    {
        "id":4
    }
}
```
<br>
<a id="atualizacaoExame"></a>
#### Atualização de Exames
A alteração de dados de Exames é feita no endereço "../api/exames/{id}" e requer um número correspondente ao id de exame previamente cadastrado no sistema como caminho da URL.

Todos os campos obrigatórios do cadastro de exame ainda são obrigatórios na alteração, porém, caso não haja interesse em alterar certos campos, é possível a omissão dos mesmos para mantê-los sem alteração.

Em caso de sucesso, é enviado um response com todos os dados do exame que tenha sido alterado.

Exemplo do Request em JSON, comparado com o request de cadastro,  alguns campos estão omitidos:
```
{
    "nome":"Mudado",
    "tipo":"Tipo de exame",
    "laboratorio":"Mudado",
    "resultado":"Resultados do exames"
    "usuario_id":
    {
        "id":2
    }
}
```
<br>

<a id="delecao"></a>
### Deleção
É possível realizar a deleçao de Pacientes, Consultas e Exames. Todas devem vir por HTTP Requests de DELETE sem necessidade de corpo.

<br>
<a id="delecaoPaciente"></a>
#### Deleção de Pacientes
A deleção de pacientes é feita por Request DELETE no endereço "../api/pacientes/{id}" e um número correspondente a um id válido de paciente deve ser inserido como caminho na URL.

Não é possível a deleção de pacientes que possuam Consultas e ou Exames cadastrados com seu id. Deve-se então deletar seus Exames e Consultas antes da deleção do paciente em si.

Em caso de sucesso, será retornado o status "204 No content".

<br>
<a id="delecaoConsulta"></a>
#### Deleção de Consultas
A deleção de Consultas é feita por Request DELETE no endereço "../api/consultas/{id}" e um número correspondente a um id válido de consulta deve ser inserido como caminho na URL.

Em caso de sucesso, será retornado o status "204 No content".

<br>
<a id="delecaoExame"></a>
#### Deleção de Exames
A deleção de Exames é feita por Request DELETE no endereço "../api/exames/{id}" e um número correspondente a um id válido de exame deve ser inserido como caminho na URL.

Em caso de sucesso, será retornado o status "204 No content".

<br>
<a id="tech"></a>
## Tecnologias

É utilizado para seu funcionamento:
- [Java] - Linguagem de programação orientada a objetos.
- [Maven] - Software de gerenciamento baseado em modelo POM.
- [Spring] - Framework open source para Java.
- [Oracle] - Banco de dados Relacional.
- [Lombok] - Biblioteca java para redução de código boilerplate.
- [Mapstruct] - Processador de anotações Java.
- [Hibernate Validation] - Validador por implementação de beans de referência.
<br>

<a id="install"></a>
## Instalação
Por se tratar de uma API Rest, o LABMedical BackEnd não possuí views. É necessário uma plataforma para envios de requests HTTPs como por exemplo o Postman para a interação com o sistema.

O LABMedical BackEnd está configurado para a conexão com o banco de dados Oracle, porém a instalação do próprio Oracle independe desta API. É possível a utilização de outros bancos relacionais como MySQL, apenas realize alterações no arquivo "..\LABMedical-BackEnd\projeto\src\main\resources\application.properties".

Para a conexão com o Banco de Dados
```
#URL do banco de dados desejado
spring.datasource.url= jdbc:oracle:thin:@localhost:1521/labmedicalbd

#Nome de usuário e senha do usuário do banco
spring.datasource.username= sys as sysdba
spring.datasource.password= admin
```

Driver para o Banco de Dados
```
spring.datasource.driver-class-name= oracle.jdbc.OracleDriver
```

Caso o Oracle não seja usado, remova ou altere a seguinte linha, responsável pelo dialéto de SQL utilizado pelo Hibernate.
```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
```

Caso haja a necessidade da remoção dos dados de teste(seeders), remove as seguintes linhas do mesmo arquivo.
```
# Garantir a inserção de seeders após a inicialização do db
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
```

Caso haja a necessidade da permanência de dados no banco de dados após a finalização da aplicação, altere a seguinte linha:
```
spring.jpa.hibernate.ddl-auto=create-drop
```
Para:
```
spring.jpa.hibernate.ddl-auto=update
```
<br>

<a id="melhorias"></a>
## Melhorias

Os critérios mais gerais que poderiam ser melhorados seriam de refatoração de código, e estabelecimento de regras de negócios mais claras e objetivas de acordo com a aplicação final do LABMedical como um todo, como por exemplo, diretivas para tratamento de erros.

Duas melhorias necessárias para uma futura versão:
- A implementação de segurança, como por exemplo a verificação por JWT e a criptografia das senhas utilizadas pelos Usuarios(médicos) do sistema.
- A implementação de paginação para todas as consultas para coleções realizadas no banco de dados.


[Java]: <https://www.java.com/>
[Maven]: <https://maven.apache.org/>
[Spring]: <https://spring.io/>
[Oracle]: <https://www.oracle.com/database/>
[Lombok]: <https://projectlombok.org/>
[Mapstruct]: <https://mapstruct.org/>
[Hibernate Validation]: <https://hibernate.org/validator/>
