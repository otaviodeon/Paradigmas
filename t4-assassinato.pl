segunda(santamaria,pedro).
segunda(portoalegre,caren).
segunda(apartamento,henrique).
segunda(apartamento,bia).
segunda(apartamento,adriano).
segunda(apartamento,alice).
segunda(santamaria,bernardo).
segunda(apartamento,maria).
terça(santamaria,pedro).
terça(portoalegre,caren).
terça(portoalegre,henrique).
terça(portoalegre,bia).
terça(apartamento,adriano).
terça(portoalegre,alice).
terça(santamaria,bernardo).
terça(santamaria,maria).
quarta(portoalegre,pedro).
quarta(portoalegre,caren).
quarta(apartamento,henrique).
quarta(portoalegre,bia).
quarta(santamaria,adriano).
quarta(portoalegre,alice).
quarta(portoalegre,bernardo).
quarta(santamaria,maria).
quinta(santamaria,pedro).
quinta(santamaria,caren).
quinta(apartamento,henrique).
quinta(santamaria,bia).
quinta(apartamento,adriano).
quinta(apartamento,alice).
quinta(santamaria,bernardo).
quinta(santamaria,maria).
sexta(apartamento,pedro).
sexta(apartamento,caren).
sexta(apartamento,henrique).
sexta(apartamento,bia).
sexta(apartamento,adriano).
sexta(apartamento,alice).
sexta(apartamento,bernardo).
sexta(apartamento,maria).

vitima(anita).

pobre(bernardo).
pobre(bia).
pobre(pedro).
pobre(maria).

insano(adriano).
insano(maria).

relacionamento(anita,bernardo).
relacionamento(bernardo,anita).
relacionamento(bernardo,caren).
relacionamento(caren,bernardo).
relacionamento(anita,pedro).
relacionamento(pedro,anita).
relacionamento(alice,pedro).
relacionamento(pedro,alice).
relacionamento(alice,henrique).
relacionamento(henrique,alice).
relacionamento(henrique,maria).
relacionamento(maria,henrique).
relacionamento(maria,adriano).
relacionamento(adriano,maria).
relacionamento(maria,caren).
relacionamento(caren,maria).

ciume(A,B) :- relacionamento(A,X), relacionamento(B,X).

motivo(X) :- insano(X); pobre(X); ciume(X,anita).

roubouArma(X) :- quinta(portoalegre,X); quarta(santamaria,X); quarta(apartamento,X); quinta(apartamento,X).
roubouChave(X) :- segunda(santamaria,X); terça(portoalegre,X).
acesso(X) :- quinta(apartamento,X), sexta(apartamento,X), roubouArma(X), roubouChave(X). 

assassino(X) :- motivo(X), acesso(X).