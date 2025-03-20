package com.example.submissionandroidexpert.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroidexpert.R
import com.example.submissionandroidexpert.core.ui.TeamAdapter
import com.example.submissionandroidexpert.detail.DetailActivity
import com.example.submissionandroidexpert.di.FavoriteModuleDependencies
import com.example.submissionandroidexpert.favorite.databinding.ActivityFavoriteBinding
import com.example.submissionandroidexpert.favorite.di.DaggerFavoriteComponent
import com.example.submissionandroidexpert.favorite.di.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.cherry_rush)

        val teamAdapter = TeamAdapter()
        teamAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTeam.observe(this) { dataTeam ->
            teamAdapter.submitList(dataTeam)
            binding.viewEmpty.root.visibility =
                if (dataTeam.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvTeam) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

}