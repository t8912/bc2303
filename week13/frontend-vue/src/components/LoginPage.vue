<template>
  <div class="login-page">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      // Perform authentication logic here
      if (this.username === 'tester' && this.password === 'pass@1234') {
        // Successful login, navigate to the main page
        this.$router.push('/main');
      } else {
        // Invalid credentials, display an error message or handle the error accordingly
        console.log('Invalid credentials');
      }
    }
  }
};
</script>

<style scoped>
.login-page {
  max-width: 400px;
  margin: 0 auto;
  padding: 40px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.login-page h1 {
  margin-bottom: 20px;
}

.login-page form div {
  margin-bottom: 10px;
}

.login-page label {
  display: block;
}

.login-page input[type="text"],
.login-page input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.login-page button {
  padding: 10px 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
