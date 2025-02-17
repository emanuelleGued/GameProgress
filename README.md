#  **Gerenciador de Progresso de Jogo**  

##  **Descrição**  
Este projeto implementa um **sistema de gerenciamento de progresso de jogo** utilizando o padrão de projeto **Memento**. O jogador pode personalizar seus atributos, salvar seu progresso e restaurá-lo quando necessário. Para tornar a interação mais intuitiva, o sistema conta com uma **interface gráfica (Swing)** onde o usuário pode definir e modificar seu estado no jogo.  

##  **Objetivo**  
O objetivo deste projeto é demonstrar o uso do **padrão Memento** para armazenar e recuperar estados anteriores de um objeto sem violar o encapsulamento. Dessa forma, o jogador pode **salvar seu progresso** e restaurá-lo caso precise voltar a um checkpoint.  

---

##  **Funcionalidades**  
 **Criar um jogador** com atributos personalizáveis  
 **Salvar o progresso** do jogador a qualquer momento  
 **Restaurar o progresso salvo** em caso de morte ou necessidade de reinício  
 **Interface gráfica (Swing)** para facilitar a interação do usuário  
 **Gerenciamento de múltiplos checkpoints**, permitindo escolher qual progresso carregar  

---

##  **Atributos do Jogador**  
O jogador possui os seguintes atributos:  
-  **Mundo** → O ambiente em que o jogador está (ex: "Terra", "Espaço", "Submundo")  
-  **Nível** → Representa a progressão do jogador (ex: 1, 10, 50)  
-  **Energia** → Mede a quantidade de vida restante do jogador  
-  **Habilidades** → Lista de habilidades desbloqueadas (ex: "Chute", "Soco", "Magia")  

##  **Tecnologias Utilizadas**  
- **Java 17+**  
- **Java Swing** para interface gráfica  
- **Padrão de projeto Memento**  
- **Maven** para gerenciamento de dependências  

---

##  **Como Executar o Projeto?**  
###  **Requisitos**  
- Ter o **Java 17+** instalado  
- Ter o **Maven** instalado  

###  **Passos para execução**  
**Clone o repositório:**  
```bash
git clone https://github.com/seu-usuario/gerenciador-progresso-jogo.git
cd gerenciador-progresso-jogo
```
**Compile o projeto com Maven:**  
```bash
mvn clean install
```  
**Execute a aplicação:**  
```bash
mvn exec:java -Dexec.mainClass="com.jogo.progresso.Main"
```  

