# 🏎️ MonocylinderExhaustDesigner

## 📋 Funcionalidades

- **Cálculo Inteligente**: Calcula o comprimento ideal e diâmetro interno do tubo de escapamento
- **Sugestão de Tubo Comercial**: Recomenda o tubo comercial mais próximo das especificações calculadas



## 🚀 Como Usar

### Acesso à Aplicação

1. **Certifique-se de que o servidor está rodando:**
   ```bash
   java -jar target/escuderiaIdeas-0.0.1-SNAPSHOT.jar
   ```

2. **Abra seu navegador e acesse:**
   ```
   http://localhost:8888
   ```

### Preenchendo o Formulário

A interface pede três informações essenciais:

#### 1. **Cilindrada (cc)**
   - Deslocamento volumétrico total do motor
   - Exemplo: 600, 1000, 1200
   - Unidade: Centímetros cúbicos (cc)

#### 2. **RPM (Rotações por Minuto)**
   - Rotação máxima do motor
   - Exemplo: 10000, 12000, 15000
   - Unidade: Rotações por minuto (rpm)

#### 3. **Ângulo da Válvula (BPMI)**
   - Ângulo entre o comando de válvulas
   - Exemplo: 240, 260, 280
   - Unidade: Graus (°)

### Obtendo os Resultados

Após preencher todos os campos e clicar em **"Calcular Escapamento"**, você receberá:

#### 📐 **Dimensões Ideais Calculadas**
- **Comprimento Ideal (mm)**: Comprimento teórico perfeito para o tubo
- **Diâmetro Interno Ideal (mm)**: Diâmetro interno teórico perfeito

#### 🔧 **Tubo Comercial Sugerido**
- **Nome do Tubo**: Identificação do tubo mais adequado disponível no mercado
- **Diâmetro Externo**: Medida externa do tubo recomendado
- **Diâmetro Interno**: Medida interna do tubo recomendado
- **Espessura da Parede**: Espessura do material do tubo

## 💡 Exemplos de Uso

### Exemplo 1: Motor de Moto 600cc
```
Cilindrada: 600
RPM: 12000
Ângulo da Válvula: 240
```

### Exemplo 2: Motor de Carro de Corrida 1200cc
```
Cilindrada: 1200
RPM: 15000
Ângulo da Válvula: 260
```

## 🎨 Design e UX

- **Cores Modernas**: Gradientes em roxo e vermelho para uma aparência profissional
- **Ícones Informativos**: Tooltips (?) para ajudar a entender cada campo
- **Feedback Visual**: Animações suaves, carregamento visível e mensagens de erro claras
- **Responsividade**: Otimizado para todos os tamanhos de tela

## ⚙️ Configurações Técnicas

### Backend
- **Framework**: Spring Boot 4.0.5
- **Linguagem**: Java 21
- **Porta**: 8888
- **Endpoint**: POST `/api/escapamento/calcular`

### Frontend
- **HTML5**: Semântica moderna
- **CSS3**: Gradientes, flexbox e grid
- **JavaScript**: Vanilla JS (sem dependências externas)
- **CORS**: Habilitado para requisições cross-origin

### Estrutura de Dados

**Request (JSON):**
```json
{
  "cc": 600,
  "rpm": 12000,
  "anguloValvulaBPMI": 240
}
```

**Response (JSON):**
```json
{
  "comprimentoIdealMM": 547.5,
  "diametroInternoIdealMM": 42.8,
  "comercialTuboSugerido": "Tubo A",
  "comercialDiametroExternoMM": 50.0,
  "comercialEspessuraParedeMM": 3.5,
  "comercialDiametroInternoMM": 43.0
}
```

## 🐛 Troubleshooting

### Erro: "Erro ao calcular escapamento"
- Verifique se o servidor está rodando na porta 8888
- Abra o console do navegador (F12) para ver mais detalhes

### A página não carrega
- Limpe o cache do navegador (Ctrl+Shift+Delete)
- Tente acessar `http://localhost:8888/index.html` diretamente

### Os estilos não estão carregando
- Verifique se os arquivos `styles.css` estão em `src/main/resources/static/`
- Recompile com `mvn clean package`

## 📱 Compatibilidade

- ✅ Chrome (últimas 2 versões)
- ✅ Firefox (últimas 2 versões)
- ✅ Safari (últimas 2 versões)
- ✅ Edge (últimas 2 versões)
- ✅ Mobile (iOS Safari, Chrome Mobile)

## 📝 Arquivos da Interface Web

```
src/main/resources/static/
├── index.html          # Estrutura HTML da página
├── styles.css          # Estilos CSS e design responsivo
└── script.js           # Lógica JavaScript e integração API
```

## 🔄 Fluxo da Aplicação

1. **Usuário acessa** → http://localhost:8888
2. **Preenche formulário** → Insere cc, rpm, anguloValvulaBPMI
3. **Clica em calcular** → JavaScript envia POST para `/api/escapamento/calcular`
4. **Backend processa** → Calcula dimensões e recomenda tubo comercial
5. **Resposta recebida** → Frontend exibe resultados com animação
6. **Novo cálculo** → Usuário pode clicar "Nova Consulta" para recalcular

## 💬 Suporte

Para dúvidas ou problemas:
- Verifique o console do navegador (F12)
- Verifique os logs do servidor
- Consulte o `pom.xml` para verificar as dependências

---

**Desenvolvido com ❤️ para performance**
Escuderia Ideas © 2026
