package parser_chat;
import java_cup.runtime.Symbol;

import java.util.LinkedList;


%%

num_uni         = [0-9]
num             = [0-9]+ ("."[0-9]*)?
letra           = [a-zA-ZÑñ]+
cad             = {letra}({letra}|{num}|"_")*
correo          = {cad}"@servidorA.com"
fecha           = ({num_uni}|({num_uni}{num_uni}))"-"({num_uni}|({num_uni}{num_uni}))"-"(({num_uni}{num_uni})|({num_uni}{num_uni}{num_uni}{num_uni}))
hora            = ({num_uni}|({num_uni}{num_uni}))":"({num_uni}|({num_uni}{num_uni}))":"({num_uni}|({num_uni}{num_uni}))
signos          =[\°#$%/?¿+-/*:,.;]

%cupsym simbolo
%class scanner
%cup
%unicode
%public
%line
%char
%ignorecase


%{
/* Lista con errores sintacticos */
public LinkedList<Errores> lista=new LinkedList<Errores>();
/* Metodo que es llamado al encontrar un error lexico */
private void ErrorScan(int linea, int columna, String valor){
lista.add(new Errores(linea, columna, "Error lexico en el caracter "+valor) );}
%}

%%



"<"             {return new Symbol(simbolo.abrir, yychar,yyline,new String(yytext()));}
">"             {return new Symbol(simbolo.cerrar, yychar,yyline,new String(yytext()));}
"\""            {return new Symbol(simbolo.c2, yychar,yyline,new String(yytext()));}

"="             {return new Symbol(simbolo.igual, yychar,yyline,new String(yytext()));}
","             {return new Symbol(simbolo.coma, yychar,yyline,new String(yytext()));}

"<LOGIN>"       {return new Symbol(simbolo.login1, yychar,yyline,new String(yytext()));}
"</LOGIN>"      {return new Symbol(simbolo.login2, yychar,yyline,new String(yytext()));}
"<USUARIO>"     {return new Symbol(simbolo.usuario1, yychar,yyline,new String(yytext()));}
"</USUARIO>"    {return new Symbol(simbolo.usuario2, yychar,yyline,new String(yytext()));}
"<CLAVE>"       {return new Symbol(simbolo.clave1, yychar,yyline,new String(yytext()));}
"</CLAVE>"      {return new Symbol(simbolo.clave2, yychar,yyline,new String(yytext()));}

"<ESTADO>"     {return new Symbol(simbolo.estado1, yychar,yyline,new String(yytext()));}
"</ESTADO>"    {return new Symbol(simbolo.estado2, yychar,yyline,new String(yytext()));}

"<ESTADO>"     {return new Symbol(simbolo.estado1, yychar,yyline,new String(yytext()));}
"</ESTADO>"    {return new Symbol(simbolo.estado2, yychar,yyline,new String(yytext()));}

"<INICIO>"     {return new Symbol(simbolo.inicio1, yychar,yyline,new String(yytext()));}
"</INICIO>"    {return new Symbol(simbolo.inicio2, yychar,yyline,new String(yytext()));}

"<ERROR>"     {return new Symbol(simbolo.error1, yychar,yyline,new String(yytext()));}
"</ERROR>"    {return new Symbol(simbolo.error2, yychar,yyline,new String(yytext()));}

"<USUARIOS>"     {return new Symbol(simbolo.usuarios1, yychar,yyline,new String(yytext()));}
"</USUARIOS>"    {return new Symbol(simbolo.usuarios2, yychar,yyline,new String(yytext()));}

"<NOMBRE>"     {return new Symbol(simbolo.nombre1, yychar,yyline,new String(yytext()));}
"</NOMBRE>"    {return new Symbol(simbolo.nombre2, yychar,yyline,new String(yytext()));}

"<FECHA>"     {return new Symbol(simbolo.fecha1, yychar,yyline,new String(yytext()));}
"</FECHA>"    {return new Symbol(simbolo.fecha2, yychar,yyline,new String(yytext()));}


{num}          {return new Symbol(simbolo.num, yychar,yyline,new String(yytext()));}
{cad}          {return new Symbol(simbolo.cad, yychar,yyline,new String(yytext()));}

{fecha}          {return new Symbol(simbolo.fecha, yychar,yyline,new String(yytext()));}
{hora}          {return new Symbol(simbolo.hora, yychar,yyline,new String(yytext()));}

{correo}          {return new Symbol(simbolo.correo, yychar,yyline,new String(yytext()));}

{signos}          {return new Symbol(simbolo.signos, yychar,yyline,new String(yytext()));}




[ \t\r\f\n]+        { /* Se ignoran */}

.                   { ErrorScan(yyline,yychar,yytext()); 

}

