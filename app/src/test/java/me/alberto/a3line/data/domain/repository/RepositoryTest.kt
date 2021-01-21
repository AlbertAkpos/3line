package me.alberto.a3line.data.domain.repository

import kotlinx.coroutines.runBlocking
import me.alberto.a3line.base.BaseTest
import me.alberto.a3line.mockdata.*
import me.alberto.a3line.util.getOrAwaitValue
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryTest : BaseTest() {
    private val localSource = FakeLocalSource(database)
    private val remoteSource = FakeRemoteSource()
    private val repository = Repository(remoteSource, localSource)

    @After
    fun tearDown() {
        database.clear()
    }

    @Test
    fun `returns a size of 0 when database is empty`() {
        val users = repository.getUsers()
        assertEquals(0, users.getOrAwaitValue().size)
    }

    @Test
    fun `returns correct number of users when database is populated from remote`() {
        runBlocking {
            repository.getRemote()
            val users = repository.getUsers()
            assertEquals(remoteResponse.size, users.getOrAwaitValue().size)
        }
    }

    @Test
    fun `returns the correct user added`() {
        val user = getUser()
        runBlocking {
            repository.addUser(user)
            val lastUserId = repository.getUsers().getOrAwaitValue().last().id
            assertEquals(user.id, lastUserId)
        }
    }

    @Test
    fun `returns correct info of updated user`() {
        val user = getUser()
        runBlocking {
            repository.addUser(user)
            user.photoUrl = "file//photo"
            //Update user
            repository.updateUser(user)

            val updatedUser = repository.getUsers().getOrAwaitValue().last()
            assertEquals(user.photoUrl, updatedUser.photoUrl)
        }
    }
}