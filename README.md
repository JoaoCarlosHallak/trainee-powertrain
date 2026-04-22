# 🏎️ Escuderia Ideas — Sistema de Dimensionamento de Escapamento (FSAE)

Este projeto é uma aplicação web desenvolvida em **Java + Spring Boot** para dimensionamento de sistemas de escapamento focados em motores monocilíndricos, com base nas metodologias clássicas de **Gordon Blair** e **A. Graham Bell**.

A aplicação evolui o modelo teórico tradicional ao incorporar critérios físicos reais, como variação de espessura de parede e seleção por diâmetro interno efetivo.

## 📌 Objetivo

Fornecer uma ferramenta capaz de:

- ✅ Calcular dimensões ideais de escapamento
- ✅ Sugerir tubos comerciais reais
- ✅ Adaptar teoria (Bell) para aplicação prática (FSAE)
- ✅ Garantir coerência física do escoamento

## ⚙️ Fundamento Teórico

Baseado no memorial técnico:

### 🔹 Comprimento do Primário (PL)
PL = ((850 * ED) / RPM) - 3


Onde:
- **ED** = 180 + ângulo de abertura da válvula de escape (BPMI)

### 🔹 Diâmetro Interno Ideal
ID = √(CC / ((PL + 3) * 25)) * 2.1


### 🔹 Cone de Transição (Scavenging)
CL = ((D_sec - D_prim) / 2) * cot(α)


Esse cone é responsável pela geração da **onda de rarefação** que auxilia na extração dos gases.

### 🔹 Comprimento do Secundário
TL = (PL + 3) - CL


## 🚀 DIFERENCIAL DO PROJETO (IMPORTANTE)

O memorial assume valores ideais.

👉 Este sistema trabalha com **valores reais de fabricação**.

### 🔥 Diferença crítica:

| Abordagem          | Memorial          | Sistema              |
|--------------------|-------------------|----------------------|
| Seleção de tubo    | Diâmetro nominal  | Diâmetro interno real|
| Espessura          | Ignorada          | Considerada          |
| Física do escoamento | Aproximada      | Real                 |

### ⚠️ Exemplo real

**Memorial considera:**
- 1 1/2" → DI = 36.1 mm

**Mas na prática:**
- 1.0 mm → 36.1 mm
- 1.5 mm → 35.1 mm

👉 **Diferença significativa** no cone e no scavenging

### ✅ Abordagem adotada
- Seleção por diâmetro interno real
- Garantia de:
  - Expansão física válida
  - Ausência de cone negativo
  - Consistência com escoamento real

## 🧠 Lógica de Seleção de Tubos

### 🔹 Primário
Selecionado como: min | DI_comercial - DI_ideal |


### 🔹 Secundário
Selecionado como:
- Menor DI > DI_primário

✔ Garante expansão  
✔ Evita erro físico  
✔ Mantém continuidade de fluxo

### 🔹 Razão de Expansão
R = D_sec / D_prim


Valores típicos:
- **1.10** → conservador
- **1.15** → ideal
- **1.20** → agressivo

## 📐 Estrutura do Sistema
src/
├── controllers/
├── services/
├── dtos/
├── utils/
└── resources/


## 🌐 Funcionalidades

- ✅ Cálculo completo do escapamento (Primário + Cone + Secundário)
- ✅ Sugestão automática de tubos comerciais
- ✅ API REST
- ✅ Interface Web simples
- ✅ Conversão automática de unidades (mm ↔ polegada)

## 🔌 API

### Endpoint
POST /api/escapamento/calcular


### Exemplo de Request
```json
{
  "cc": 249,
  "rpm": 8000,
  "anguloValvulaBPMI": 64,
  "anguloDivergencia": 7.5
}

📊 Exemplo de Saída
{
  "comprimentoIdealPrimarioMM": 582.29,
  "diametroInternoIdealPrimarioMM": 33.06,
  "comercialPrimarioTuboSugerido": "1 3/8 (1.0mm)",
  "comercialSecundarioTuboSugerido": "1 1/2 (1.5mm)",
  "comprimentoConeTransicaoMM": 8.28,
  "comprimentoIdealSecundarioMM": 650.22,
  "razaoExpansao": 1.15
}

🧪 Como Executar
Pré-requisitos
- Java 21
- Maven
.Passos
  Clone o repositório
  Navegue até o diretório do projeto
  Execute:
  mvn spring-boot:run
  Acesse: http://localhost:8888/index.html

  🏗️ Engenharia Aplicada
🔥 O que este projeto resolve
Elimina erro comum de usar diâmetro externo
Corrige inconsistências do modelo teórico
Permite adaptação para tubos reais disponíveis
Mantém coerência com dinâmica de ondas de pressão
⚠️ Limitações
Modelo ainda baseado em aproximações empíricas (Bell)

Não considera:

Temperatura variável
Múltiplos cilindros
Interação com abafador