create database ExchangeData;
use ExchangeData;

create table MyExchange(
       idEx           int not null unique AUTO_INCREMENT PRIMARY KEY,
       ExchangeName   varchar(255) not null
);

create table PriceAnalyst(
       idAP           int not null unique AUTO_INCREMENT PRIMARY KEY,
       PersonName     varchar(255) not null
);

create table ExPA(
       idEx           int not null,
       idAP           int not null,
       PRIMARY KEY (idEx, idAP)
);

create table Stocks(
       idS            int not null unique AUTO_INCREMENT PRIMARY KEY,
	   CompanyName    varchar(255) not null,
       Price          double       not null
);

create table ExSt(
       idEx          int not null,
       idS           int not null,
       PRIMARY KEY (idEx, idS)
);

create table IndexAnalyst(
       idAI           int not null unique AUTO_INCREMENT PRIMARY KEY,
       PersonName     varchar(255) not null
);

create table ExAI(
       idEx           int not null,
       idAI           int not null,
       PRIMARY KEY (idEx, idAI)
);

create table ExchangesIndexes(
       idI                 int not null unique AUTO_INCREMENT PRIMARY KEY,
       IndexExchange       double not null
);

create table ExPI(
       idEx           int not null,
       idI            int not null,
       PRIMARY KEY (idEx, idI)
);



# MyExchange  - ExPA   1:m
ALTER TABLE ExPA ADD CONSTRAINT fk_id_ExExPA
FOREIGN KEY (idEx) REFERENCES MyExchange (idEx)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

# PriceAnalyst - ExPA    1:m    
ALTER TABLE ExPA ADD CONSTRAINT fk_id_PAExPA
FOREIGN KEY (idAP) REFERENCES PriceAnalyst (idAP)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    
# MyExchange  - ExSt   1:m
ALTER TABLE ExSt ADD CONSTRAINT fk_id_ExExSt
FOREIGN KEY (idEx) REFERENCES MyExchange (idEx)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

# Stocks - ExSt   1:m    
ALTER TABLE ExSt ADD CONSTRAINT fk_id_SExSt
FOREIGN KEY (idS) REFERENCES Stocks (idS)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    
    
# MyExchange - ExAI 1:m
ALTER TABLE ExAI ADD CONSTRAINT fk_id_ExExPiA
FOREIGN KEY (idEx) REFERENCES MyExchange (idEx)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    

# IndexAnalyst - ExAI  1:m
ALTER TABLE ExAI ADD CONSTRAINT fk_id_IAExPI
FOREIGN KEY (idAI) REFERENCES IndexAnalyst (idAI)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
        
# MyExchange - ExPI   1:m
ALTER TABLE ExPI ADD CONSTRAINT fk_id_ExPIIA
FOREIGN KEY (idI) REFERENCES ExchangesIndexes (idI)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    
# ExchangesIndexes - ExPI   1:m
ALTER TABLE ExPI ADD CONSTRAINT fk_id_ExPIEx
FOREIGN KEY (idEx) REFERENCES MyExchange (idEx)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
    



select * from Stocks;

select * from MyExchange;

select * from PriceAnalyst;

select * from  ExPA;

select * from IndexAnalyst;

select * from  ExAI;

select * from  ExchangesIndexes;

select * from  ExPI;



DROP DATABASE ExchangeData;



