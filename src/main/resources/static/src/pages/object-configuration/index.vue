<template>
    <div>
        <h1 class="slds-text-heading_large slds-m-bottom_x-large">Object Configuration</h1>
        <form @submit="submitCredentials">
        	<label>{{ title }}</label>
    		<input type="text" v-model="description"/>
            <input class="slds-button slds-button_brand" type="submit" value="add" />
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
            getall() {
                fetch('#').then(response => {
                    if(response.ok) {
                        return response.json();
                    }
                }).then(jsonResponse => {
                    console.log(jsonResponse);
                });
            },
            submitCredentials() {

            }
    	},
        mounted() {
            this.getall();
        }
    }
</script>

<style scoped>

</style>
