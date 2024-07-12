"""
Calculadora de Juros Compostos
---------------------------------
Autor: Leandro Santana
Data de Criação: 09.07.2024
versão: 1.0
Email: Leandroedv@hotmail.com

Descrição: 
    -Este aplicativo permite que o usuário insira o valor inicial, a contribuição mensal, a taxa de juros e o período
     para calcular o valor final dos juros compostos.

Dependências:
    - customtkinter
    - tkinter
    - calculadora (módulo customizado para cálculo de juros compostos)
"""

# IMPORTAÇÃO DE BIBLIOTECAS
import customtkinter as ctk
from tkinter import *
from tkinter import messagebox, ttk
from calculadora import calc # módulo personalizado 
import re

class App(ctk.CTk):
    def __init__(self):        
        super().__init__()
        self.tela_de_cadastro()
        self.tela_de_login()
        self.configuracoes_da_janela_inicial()

    # configurando a janela principal - main screean configuration
    def configuracoes_da_janela_inicial(self):
        self.geometry("810x550")
        self.title("Sistema de login")
        self.resizable(False, False) 
        
    def tela_de_login(self):
        # IMPORTAÇÃO DE IMAGENS
        self.img = PhotoImage(file="img/login_img.png")
        self.img = self.img.subsample(6,6)
        self.label_img = ctk.CTkLabel(self, text=None, image=self.img)
        self.label_img.grid(row=1, column=0, padx=10)
        
    def tela_de_cadastro(self):
        
        # FRAME DE FORMULÁRIO DE CADASTRO
        self.frame_register = ctk.CTkFrame(self)
        self.frame_register.grid(row=1, column=1)
        
        #CRIAR WIDGETS TELAS DE CADASTRO
        self.label_title = ctk.CTkLabel(self, text="Calculadora de Juros compostos", font=("Century Gothic bold", 24), text_color='#416698')
        self.label_title.grid(row=0, column=0, padx=10, pady=15)
        
        self.initial_value = ctk.CTkLabel(self.frame_register, text="Valor Inicial", font=("Century Gothic bold", 16))
        self.initial_value.grid(row=1, column=0, padx=5, pady=1,sticky=W)
        
        self.initial_value_entry = ctk.CTkEntry(self.frame_register, width=200, corner_radius=10, placeholder_text="R$", font=("Century Gothic bold", 16))
        self.initial_value_entry.grid(row=2, column=0, padx=5, pady=1, sticky=W)
        
        self.label_monthly_value = ctk.CTkLabel(self.frame_register, text="Valor mensal", font=("Century Gothic bold", 16))
        self.label_monthly_value.grid(row=1, column=1, padx=5, pady=1, sticky=W)
        
        self.monthly_contribution_entry = ctk.CTkEntry(self.frame_register, width=200, corner_radius=10, placeholder_text="R$ aporte", font=("Century Gothic bold", 16))
        self.monthly_contribution_entry.grid(row=2, column=1, padx=5, pady=1, sticky=W)
        
        self.interest_rate_value = ctk.CTkLabel(self.frame_register, text="Taxa de Juros", font=("Century Gothic bold", 16))
        self.interest_rate_value.grid(row=3, column=0, padx=5, pady=1,sticky=W)
        
        
        self.interest_rate_entry = ctk.CTkEntry(self.frame_register, width=200, corner_radius=10,  placeholder_text="%", font=("Century Gothic bold", 16))
        self.interest_rate_entry.grid(row=4, column=0, padx=5, pady=1, sticky=W)
        self.interest_rate_entry.bind('<KeyRelease>', self.get_atibutes)
        
        self.period_value = ctk.CTkLabel(self.frame_register, text="Período", font=("Century Gothic bold", 16))
        self.period_value.grid(row=3, column=1, padx=5, pady=1,sticky=W)
        
        self.period_value_entry = ctk.CTkEntry(self.frame_register, width=200, corner_radius=10, placeholder_text="mêses", font=("Century Gothic bold", 16))
        self.period_value_entry.grid(row=4, column=1, padx=5, pady=1, sticky=W)

        self.btn_register_user = ctk.CTkButton(self.frame_register, width=200, corner_radius=15, command=self.calculate ,fg_color="#04c981", hover_color="#01915d", text="Calcular", font=("Century Gothic bold", 16))
        self.btn_register_user.grid(row=6, column=1, padx=5, pady=20, sticky=E )

        #self.btn_login_back = ctk.CTkButton(self.frame_register, width=300, corner_radius=15,command= "", text="Voltar ao Login", font=("Century Gothic bold", 14))
        #self.btn_login_back.grid(row=7, column=0, padx=10, pady=5)
        # Frame para o resusltado 
        
        self.frame_result = ctk.CTkFrame(self.frame_register)
        self.frame_result.grid(row=7, column=1)
        
        self.label_total = ctk.CTkLabel(self.frame_result, text="Valor Total:", font=("Century Gothic bold", 16))
        self.label_total.grid(row=0, column=0, padx=5, pady=1, sticky=E)
        
        self.result_total = ttk.Label(self.frame_result, font=("Century Gothic bold", 18), text="0,00 R$")
        self.result_total.grid(row=0, column=1, padx=5, pady=5, sticky=E)
        
    def clear_entry_register(self):
        self.initial_value_entry.delete(0, END)
        self.interest_rate_entry.delete(0, END)
        #self.password_register_entry.delete(0, END)
       # self.confirm_password_register_entry.delete(0, END)
       
    def get_atibutes(self, event = None):
        
        pattern = r'^\d{1,3}$'
        
        if re.findall(pattern, self.interest_rate_entry.get()): 
                print('passou')
        else:
            self.interest_rate_entry.delete(0,END)
        
            
        
        
        
    def calculate(self):
        try:
            capital_aplicado = float(self.initial_value_entry.get())
            aporte_mensal = float(self.monthly_contribution_entry.get())
            taxa_de_juros = float(self.interest_rate_entry.get())
            tempo_da_aplicacao = float(self.period_value_entry.get())
            result = calc(capital_aplicado, aporte_mensal, taxa_de_juros, tempo_da_aplicacao )
            
            self.result_total.config(text= f'{result :.2f}')
        except:
            msg = messagebox.showerror('Erro','Digite um valor válido')
            
        
        #self.result = result
        
        
if __name__ == "__main__":
    app = App()
    app.mainloop()