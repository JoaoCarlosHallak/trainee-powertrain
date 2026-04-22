const form = document.getElementById('exhaustForm');
const resultContainer = document.getElementById('resultContainer');
const errorContainer = document.getElementById('errorContainer');
const loadingContainer = document.getElementById('loadingContainer');

const ccInput = document.getElementById('cc');
const rpmInput = document.getElementById('rpm');
const anguloInput = document.getElementById('angulo');
const divergenciaInput = document.getElementById('divergencia');

const comprimentoPrimarioEl = document.getElementById('comprimentoPrimario');
const diametroPrimarioEl = document.getElementById('diametroPrimario');
const comprimentoSecundarioEl = document.getElementById('comprimentoSecundario');
const comprimentoConeEl = document.getElementById('comprimentoCone');
const tuboPrimarioNomeEl = document.getElementById('tuboPrimarioNome');
const primarioDiaExtEl = document.getElementById('primarioDiaExt');
const primarioDiaIntEl = document.getElementById('primarioDiaInt');
const primarioEspessuraEl = document.getElementById('primarioEspessura');
const tuboSecundarioNomeEl = document.getElementById('tuboSecundarioNome');
const secundarioDiaExtEl = document.getElementById('secundarioDiaExt');
const secundarioDiaIntEl = document.getElementById('secundarioDiaInt');
const secundarioEspessuraEl = document.getElementById('secundarioEspessura');
const razaoExpansaoEl = document.getElementById('razaoExpansao');

const API_URL = 'http://localhost:8888/api/escapamento/calcular';

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const cc = parseInt(ccInput.value, 10);
    const rpm = parseInt(rpmInput.value, 10);
    const anguloValvulaBPMI = parseInt(anguloInput.value, 10);
    const anguloDivergencia = parseFloat(divergenciaInput.value);
    if (!cc || !rpm || !anguloValvulaBPMI || isNaN(anguloDivergencia)) {
        showError('Por favor, preencha todos os campos obrigatórios.');
        return;
    }

    if (cc <= 0 || rpm <= 0 || anguloValvulaBPMI <= 0 || anguloDivergencia <= 0) {
        showError('Todos os valores devem ser maiores que zero.');
        return;
    }

    const payload = {
        cc,
        rpm,
        anguloValvulaBPMI,
        anguloDivergencia
    };

    showLoading();
    hideResults();
    hideError();

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload)
        });

        if (!response.ok) {
            throw new Error(`Erro HTTP! Status: ${response.status}`);
        }

        const data = await response.json();
        displayResults(data);
        showResults();
        hideError();

    } catch (error) {
        console.error('Erro na requisição:', error);
        showError(`Erro ao calcular escapamento: ${error.message}. Verifique se o servidor está rodando em ${API_URL}`);
    } finally {
        hideLoading();
    }
});

function displayResults(data) {
    comprimentoPrimarioEl.textContent = formatNumber(data.comprimentoIdealPrimarioMM);
    diametroPrimarioEl.textContent = formatNumber(data.diametroInternoIdealPrimarioMM);
    comprimentoSecundarioEl.textContent = formatNumber(data.comprimentoIdealSecundarioMM);
    comprimentoConeEl.textContent = formatNumber(data.comprimentoConeTransicaoMM);
    tuboPrimarioNomeEl.textContent = data.comercialPrmarioTuboSugerido || 'N/A';
    primarioDiaExtEl.textContent = formatNumber(data.comercialPrimarioDiametroExternoMM);
    primarioDiaIntEl.textContent = formatNumber(data.comercialPrimarioDiametroInternoMM);
    primarioEspessuraEl.textContent = formatNumber(data.comercialPrimarioEspessuraParedeMM);
    tuboSecundarioNomeEl.textContent = data.comercialSecundarioTuboSugerido || 'N/A';
    secundarioDiaExtEl.textContent = formatNumber(data.comercialSecundarioDiametroExternoMM);
    secundarioDiaIntEl.textContent = formatNumber(data.comercialSecundarioDiametroInternoMM);
    secundarioEspessuraEl.textContent = formatNumber(data.comercialSecundarioEspessuraParedeMM);
    razaoExpansaoEl.textContent = formatNumber(data.razaoExpansao);
}

function formatNumber(num) {
    if (typeof num !== 'number') return '0.00';
    return num.toFixed(2);
}

function showResults() {
    resultContainer.classList.remove('hidden');
    resultContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
}

function hideResults() {
    resultContainer.classList.add('hidden');
}

function showError(message) {
    errorContainer.textContent = '';
    const p = document.createElement('p');
    p.textContent = message;
    errorContainer.appendChild(p);
    errorContainer.classList.remove('hidden');
    errorContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
}

function hideError() {
    errorContainer.classList.add('hidden');
}

function showLoading() {
    loadingContainer.classList.remove('hidden');
}

function hideLoading() {
    loadingContainer.classList.add('hidden');
}

function resetForm() {
    form.reset();
    hideResults();
    hideError();
    ccInput.focus();
}

document.addEventListener('DOMContentLoaded', () => {
    ccInput.focus();
});
