import a from 'components/App.vue'

<!--
<template> 
  <div>
    <div v-if="authenticated"> -->
      <!-- Existing content -->
      <!-- Marquee -->
      <!-- Table -->
   <!-- </div> 
    <div v-else>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      authenticated: false
    };
  },
  created() {
    // Check if the user is already authenticated (e.g., with a token in localStorage)
    // Set the "authenticated" data property accordingly
    // Example:
    const token = localStorage.getItem('token');
    this.authenticated = !!token;
  }
};
</script>

<style>
/* Existing styles */
</style>
-->