import math

#montante <- Valor total após o periodo
#capital_aplicado <- valor inicial
#taxa_de_juros = <- taja de juros (%)
#tempo_da_aplicacao <- Tempo em meses 
#juros_composto = 
#aporte_mensal = <- valor aplicado de forma mensal

def calc(capital_aplicado, aporte_mensal, taxa_de_juros, tempo_da_aplicacao ):
    
    pmt = 0
    montante = (capital_aplicado * ((1+ taxa_de_juros) ** tempo_da_aplicacao  )) + (aporte_mensal * ((((1 + taxa_de_juros) ** tempo_da_aplicacao  )-1) / taxa_de_juros))
    #print(pmt)
    #print(f'{montante:.2f}')
    return montante

#calc(100, 100, 0.010, 12) # taxa de juros de 1%

class screen():
    def __init__():
        pass

