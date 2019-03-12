<template>
    <div>
        <h1 class="slds-text-heading_large slds-m-bottom_x-large">App Configuration - David</h1>
        <form>
        	<label>{{ title }}</label>
    		<input type="text" v-model="description"/> <button type="button">Add</button>
    	</form>
    </div>
</template>

<script>
    export default {
    	data() {
    		return {
    			title: 'SOAP Object Configuration',
    			description: null
    		}
    	},
    	methods: {

    	}
    }
</script>

<style scoped>

</style>
