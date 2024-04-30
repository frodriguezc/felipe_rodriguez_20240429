import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import tech.carcher.felipe_rodriguez_20240429.Player
import tech.carcher.felipe_rodriguez_20240429.R

class PlayersAdapter(
    private val players: List<Player>,
    private val context: Context
) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.player_image)
        val nameView: TextView = view.findViewById(R.id.player_name)
        val teamView: TextView = view.findViewById(R.id.player_team)
        val playVideoButton: ImageView = view.findViewById(R.id.play_video_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        holder.imageView.setImageResource(player.photoUrl)
        holder.nameView.text = player.name
        holder.teamView.text = player.team

        holder.playVideoButton.setOnClickListener {
//            val videoResourceUri = Uri.parse(player.videoUrl)
            val videoResourceUri = Uri.parse("android.resource://${context.packageName}/res/raw/${player.name.lowercase()}")
            Log.d("URI", "Uri: $videoResourceUri")
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(videoResourceUri, "video/mp4")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = players.size
}