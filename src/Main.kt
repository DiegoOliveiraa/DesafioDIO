package src

class main {
    enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

    data class Usuario(val nome: String, val nivel: Nivel, val materia: ConteudoEducacional, val formacao: Formacao)

    data class ConteudoEducacional(var nome: String, val duracao: Int)

    data class Formacao(val nome: String, var conteudos: String) {
        val inscritos = mutableListOf<Usuario>()
        val lista: MutableList<Usuario> = inscritos

        fun matricular(usuario: Usuario) {
            inscritos.add(usuario)
        }

        fun getSysList(): MutableList<Usuario> {
            return lista
        }
    }

    fun main() {

        val direito = Formacao("direito", "é us guri")
        val professor = Formacao("professor", "é us gu")
        val quimico = Formacao("quimico", "é us ri")


        // Matérias

        val portugues = ConteudoEducacional("português", duracao = 30)
        val matematica = ConteudoEducacional("matematica", duracao = 40)
        val ciencias = ConteudoEducacional("ciencias", duracao = 50)

        //Alunos

        val usuario1 = Usuario("Diego", Nivel.BASICO, ciencias, quimico)
        val usuario2 = Usuario("Luiza", Nivel.INTERMEDIARIO, matematica, professor)
        val usuario3 = Usuario("Isaac", Nivel.DIFICIL, portugues, direito)

        //tempo de aula
        println(usuario2.materia.duracao)

        //Matricula
        usuario1.formacao.matricular(usuario1)
        usuario2.formacao.matricular(usuario2)
        usuario3.formacao.matricular(usuario3)

        //Chamada do Diego
        println(usuario1.formacao.getSysList())

    }
}