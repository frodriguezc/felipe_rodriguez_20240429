package tech.carcher.felipe_rodriguez_20240429

import PlayersAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PlayersAdapter(listOfPlayers(), this)
    }

    private fun listOfPlayers(): List<Player> {
        return listOf(
            Player("Diego", "Boca", R.drawable.diego, R.raw.diego),
            Player("Pele", "Barcelona", R.drawable.pele, R.raw.pele),
            Player("Condor", "Boca", R.drawable.condor, R.raw.condor),
            Player("Roberto Carlos", "Barcelona", R.drawable.roberto, R.raw.roberto),
        )
    }
}