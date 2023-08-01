package src

class Main {
    enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

    data class Usuario(val nome: String, val nivel: Nivel, val materia: ConteudoEducacional, val formacao: Formacao)

    data class ConteudoEducacional(val nome: String, val duracao: Int)

    data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional>) {
        val inscritos = mutableListOf<Usuario>()

        fun matricular(usuario: Usuario) {
            inscritos.add(usuario)
        }

        fun getInscritos(): List<Usuario> {
            return inscritos
        }
    }

    fun main() {
        val direito = Formacao("direito", mutableListOf())
        val professor = Formacao("professor", mutableListOf())
        val quimico = Formacao("quimico", mutableListOf())

        // Matérias
        val portugues = ConteudoEducacional("português", duracao = 30)
        val matematica = ConteudoEducacional("matematica", duracao = 40)
        val ciencias = ConteudoEducacional("ciencias", duracao = 50)

        // Alunos
        val usuario1 = Usuario("Diego", Nivel.BASICO, ciencias, quimico)
        val usuario2 = Usuario("Luiza", Nivel.INTERMEDIARIO, matematica, professor)
        val usuario3 = Usuario("Isaac", Nivel.DIFICIL, portugues, direito)

        // Tempo de aula
        println(usuario2.materia.duracao)

        // Matricula
        direito.matricular(usuario1)
        professor.matricular(usuario2)
        quimico.matricular(usuario3)

        // Chamada do Diego
        println(direito.getInscritos())
    }
}
