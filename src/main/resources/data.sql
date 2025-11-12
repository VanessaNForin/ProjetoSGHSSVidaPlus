-- 🏥 HOSPITAIS
INSERT INTO hospitais (identificador_hospital, nome_hospital, endereco, telefone)
VALUES
('HOS0001', 'Hospital VidaPlus', 'Rua das Flores, 123 - São Paulo/SP', '(11) 2345-6789'),
('HOS0002', 'Hospital Esperança', 'Avenida Central, 456 - Rio de Janeiro/RJ', '(21) 3456-7890');

-- 🛏️ LEITOS
INSERT INTO leitos (identificador_leito, hospital_id, andar, numero_leito)
VALUES
('LEI0001', 'HOS0001', 1, 101),
('LEI0002', 'HOS0001', 1, 102),
('LEI0003', 'HOS0001', 2, 201),
('LEI0004', 'HOS0002', 1, 103),
('LEI0005', 'HOS0002', 3, 301);

-- 👨‍⚕️ MÉDICOS
INSERT INTO medicos (
    identificador_medico,
    nome_completo,
    data_de_nascimento,
    cpf,
    endereco,
    telefone,
    cadastro_ativo,
    especialidade,
    crm
) VALUES
('MED0001', 'Dr. João Henrique Silva', '1980-05-12', '145.928.657-90', 'Rua das Palmeiras, 45 - São Paulo/SP', '(11)99876-5522', TRUE, 'CLINICO_GERAL', '867806-VH'),
('MED0002', 'Dra. Marina Costa Andrade', '1985-09-28', '392.174.002-31', 'Av. Brasil, 1200 - Rio de Janeiro/RJ', '(21)98745-1023', TRUE, 'PEDIATRIA', '432109-XK');

-- 👩‍⚕️ ENFERMEIROS
INSERT INTO enfermeiros (
    identificador_enfermeiro,
    nome_completo,
    data_de_nascimento,
    cpf,
    endereco,
    telefone,
    cadastro_ativo,
    hospital_id,
    e_supervisora,
    e_plantonista,
    coren
) VALUES
('ENF0001', 'Enf. Larissa Moura Santos', '1992-07-15', '284.765.901-44', 'Rua das Rosas, 88 - São Paulo/SP', '(11)99642-8731', TRUE, 'HOS0001', TRUE, FALSE, 'SP-238746-H'),
('ENF0002', 'Enf. Carlos Eduardo Lima', '1988-03-02', '357.918.620-19', 'Av. Central, 340 - Rio de Janeiro/RJ', '(21)98563-2198', TRUE, 'HOS0002', FALSE, TRUE, 'RJ-198452-G');

-- 🧍‍♀️ PACIENTE 1
INSERT INTO pacientes (
    identificador_paciente,
    nome_completo,
    data_de_nascimento,
    cpf,
    endereco,
    telefone,
    cadastro_ativo,
    profissao,
    tipo_convenio,
    contato_emergencia
) VALUES (
    'PAC0001',
    'Ana Paula Ferreira',
    '1988-03-15',
    '123.456.789-10',
    'Rua das Flores, 45 - Campinas/SP',
    '(19)99765-2234',
    TRUE,
    'Professora',
    'FAMILIAR',
    'Carlos Ferreira - Esposo (19)99543-2210'
);

-- Alergias de Ana Paula
INSERT INTO paciente_alergia (paciente_id, alergias) VALUES
('PAC0001', 'Dipirona'),
('PAC0001', 'Amendoim');

-- 🧍 PACIENTE 2
INSERT INTO pacientes (
    identificador_paciente,
    nome_completo,
    data_de_nascimento,
    cpf,
    endereco,
    telefone,
    cadastro_ativo,
    profissao,
    tipo_convenio,
    contato_emergencia
) VALUES (
    'PAC0002',
    'Rogério dos Santos',
    '1979-09-02',
    '987.654.321-00',
    'Av. Brasil, 210 - Belo Horizonte/MG',
    '(31)98890-7765',
    TRUE,
    'Motorista',
    'INDIVIDUAL',
    'Marina Santos - Esposa (31)98455-0032'
);

-- Alergias de Rogério
INSERT INTO paciente_alergia (paciente_id, alergias) VALUES
('PAC0002', 'Frutos do mar'),
('PAC0002', 'Poeira');

-- Internação 1
INSERT INTO internacoes (
    identificador_internacao,
    paciente_id,
    leito_id,
    esta_ativo,
    data_entrada,
    data_alta,
    medico_id,
    enfermeiro_id,
    prontuario
) VALUES (
    'INT0001',
    'PAC0001',
    'LEI0001',
    TRUE,
    '2025-11-10T08:30:00',
    NULL,
    'MED0001',
    'ENF0001',
    'Paciente admitido com quadro de pneumonia. Iniciado tratamento com antibióticos e repouso absoluto. Monitoramento constante dos sinais vitais.'
);

-- Internação 2
INSERT INTO internacoes (
    identificador_internacao,
    paciente_id,
    leito_id,
    esta_ativo,
    data_entrada,
    data_alta,
    medico_id,
    enfermeiro_id,
    prontuario
) VALUES (
    'INT0002',
    'PAC0002',
    'LEI0002',
    TRUE,
    '2025-11-11T10:15:00',
    NULL,
    'MED0002',
    'ENF0002',
    'Paciente pós-operatório de apendicectomia. Recuperação estável. Mantido jejum nas primeiras 12h e hidratação venosa contínua.'
);


